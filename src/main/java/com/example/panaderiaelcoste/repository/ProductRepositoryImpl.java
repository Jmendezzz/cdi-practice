package com.example.panaderiaelcoste.repository;

import com.example.panaderiaelcoste.annotations.MySqlConn;
import com.example.panaderiaelcoste.conecction.ProducerResources;
import com.example.panaderiaelcoste.model.Product;
import com.example.panaderiaelcoste.annotations.Repository;
import jakarta.inject.Inject;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepositoryImpl implements CrudRepository<Product> {

    @Inject
    @MySqlConn
    private Connection conn;

    public ProductRepositoryImpl() {


    }

    @Override
    public List<Product> findAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Product")) {
            while (rs.next()) {
                Product p = createProduct(rs);
                products.add(p);
            }
        }
        return products;

    }

    @Override
    public Product findById(Long id){

        Product product = null;

        try(PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Product WHERE id=?")){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                product = createProduct(resultSet);

            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return product;
    }

    @Override
    public void save(Product product) {

        try(PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Product(name,available_amount,url_image,is_available,price) values (?,?,?,?,?)")){
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getAvaibleAmount());
            preparedStatement.setString(3,product.getUrlImage());
            preparedStatement.setBoolean(4, product.isStatus());
            preparedStatement.setDouble(5,product.getPrice());
            System.out.println("Repository:"+ conn);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            throw  new RuntimeException(e);
        }

    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement preparedStatement = conn.prepareStatement("DELETE  FROM  Product where  id= ?")){
            preparedStatement.setLong(1, id );
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    private Product createProduct(ResultSet rs) throws SQLException {

        Product product = new Product();
        product.setId( rs.getLong("id") );
        product.setName(rs.getString("name"));
        product.setAvaibleAmount(rs.getInt("available_amount"));
        product.setUrlImage(rs.getString("url_image"));
        product.setStatus(rs.getBoolean("is_available"));
        product.setPrice(rs.getDouble("price"));
        return product;


    }
}
