/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DAO.addMusica;

import com.example.Model.musica;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author paulo.bezerra
 */
public class listMusicas {

    public  List<musica> List() {
        
        //indica as configuracoes do banco
        Configuration con = new Configuration().configure().addAnnotatedClass(musica.class);
        SessionFactory sf = con.buildSessionFactory();

        //abre sessao com o banco
        Session session = sf.openSession();
        List<musica> musicas;

        try {
            

            Transaction tx = session.beginTransaction();

            String hql = "from musica";

            musicas = session.createQuery(hql).list();

            //comita as informacoes
            tx.commit();
            
        } finally {
            if (session != null) {
                session.close();
                sf.close();
            }

        }
        

        return musicas;
    }

}
