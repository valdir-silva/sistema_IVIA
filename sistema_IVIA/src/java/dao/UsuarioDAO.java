/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import entity.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConexaoDB;
import util.exception.Erros;

/**
 *
 * @author valdir.silva
 */
public class UsuarioDAO implements CrudDAO<Usuario> {

    @Override
    public void salvar(Usuario entidade) throws Erros {
        try {
            Connection conexao = ConexaoDB.getConexao();
            PreparedStatement ps;
            if (entidade.getId() == null) {
                ps = conexao.prepareStatement("INSERT INTO usuario (nome,email,senha) VALUES (?,?,?);");
            } else {
                ps = conexao.prepareStatement("UPDATE usuario SET nome=?, email=?, senha=? WHERE id=?;");
                ps.setInt(4, entidade.getId()); // WHERE
            }
            ps.setString(1, entidade.getNome());
            ps.setString(2, entidade.getEmail());
            ps.setString(3, entidade.getSenha());
            ps.execute();
            ConexaoDB.fecharConexao();
        } catch (SQLException ex) {
            throw new Erros("Erro ao tentar salvar!", ex);
        }
    }

    @Override
    public void deletar(Usuario entidade) throws Erros {
        try {
            Connection conexao = ConexaoDB.getConexao();
            PreparedStatement ps = conexao.prepareStatement("delete from usuario where id = ?");
            ps.setInt(1, entidade.getId());
            ps.execute();
        } catch (SQLException ex) {
            throw new Erros("Erro ao deletar o usuario!", ex);
        }
    }

    @Override
    public List<Usuario> buscar() throws Erros {
        try {
            Connection conexao = ConexaoDB.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from usuario");
            ResultSet resultSet = ps.executeQuery();
            List<Usuario> usuarios = new ArrayList<>();
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setSenha(resultSet.getString("senha"));
                usuarios.add(usuario);
            }
            ConexaoDB.fecharConexao();
            return usuarios;

        } catch (SQLException ex) {
            throw new Erros("Erro ao buscar os usuarios!", ex);
        }
    }

}
