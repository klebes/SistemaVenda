/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.dao;

import br.com.venda.jdbc.ConectorFactory;
import br.com.venda.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author KDS
 */
public class ClienteDao {
    private Connection con;
    public ClienteDao(){
        this.con = new ConectorFactory().getConnection();
    }
    //metodo cadastrar cliente
    public void cadastrarCliente(Cliente clienteobj){
        try {
            //comando sql
            String sql = "insert into tb_clientes(nome, rg,cpf,email,telefone,celular,cep,endereco, numero, complemento, bairro, cidade, estado)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            //passar os campos ao sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, clienteobj.getNome());
            stmt.setString(2, clienteobj.getRg());
            stmt.setString(3, clienteobj.getCpf());
            stmt.setString(4, clienteobj.getEmail());
            stmt.setString(5, clienteobj.getTelefone());
            stmt.setString(6, clienteobj.getCelular());
            stmt.setString(7, clienteobj.getCep());
            stmt.setString(8, clienteobj.getEndereco());
            stmt.setInt(9, clienteobj.getNumero());
            stmt.setString(10, clienteobj.getComplemento());
            stmt.setString(11, clienteobj.getBairro());
            stmt.setString(12, clienteobj.getCidade());
            stmt.setString(13, clienteobj.getEstado());
            
            //executar o comando sql
            stmt.execute();
            //fechar o comando sql
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado com sucesso!");
     
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente" + error);
        }
    }
    //metodo alterar cliente
    public void alterarCliente(){
        
    }
    //metodo excluir cliente
    public void excluirCliente(){
        
    }
    //metodo listar clietne
    public List<Cliente> listarCliente(){
        try {
            //criacao da lista
            List<Cliente> lista = new ArrayList<>();
            //sql listar
            String sql = "select * from tb_clientes";
            PreparedStatement stmt = con.prepareCall(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente clienteobj = new Cliente();
                clienteobj.setId(rs.getInt("id"));
                clienteobj.setNome(rs.getString("nome"));
                clienteobj.setRg(rs.getString("rg"));
                clienteobj.setCpf(rs.getString("cpf"));
                clienteobj.setEmail(rs.getString("email"));
                clienteobj.setTelefone(rs.getString("telefone"));
                clienteobj.setCelular(rs.getString("celular"));
                clienteobj.setCep(rs.getString("cep"));
                clienteobj.setEndereco(rs.getString("endereco"));
                clienteobj.setNumero(rs.getInt("numero"));
                clienteobj.setComplemento(rs.getString("complemento"));
                clienteobj.setBairro(rs.getString("bairro"));
                clienteobj.setCidade(rs.getString("cidade"));
                clienteobj.setEstado(rs.getString("estado"));
                
                lista.add(clienteobj);

            }
            return lista;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro - impossivel buscar cliente " + error);
            return null;
        }
    }
}
