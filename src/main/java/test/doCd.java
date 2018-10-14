package test;

import entities.Cd;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Scanner;

public class doCd {

    Session session = null;
    Transaction tx = null;
    Long testID = null;
    List<Cd> listCd = null;
    SessionFactory mFactory = null;
    Scanner scan = new Scanner(System.in);

    public  void selectCd() {

        try {
            mFactory = HibernateUtil.getSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Couldn't create session factory." + ex);
            System.err.println("Next work unpossible!" + ex);
            System.exit(300);
        }
        try {
            session = mFactory.openSession();
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Cd.class);
            listCd = (List<Cd>) criteria.list();
            tx.commit();
            System.out.println("\n\n Данные с таблицы CD:");
            for (Cd cd : listCd) {
                System.out.println(cd.toString());
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        System.out.println("=== The end session Select CD ===");
    }
    public  void deleteCd(){
        try {
            mFactory = HibernateUtil.getSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Couldn't create session factory." + ex);
            System.err.println("Next work unpossible!" + ex);
            System.exit(300);
        }
        listCd = null;
        session = mFactory.openSession();
        tx = null;
        System.out.println("______________________________________________________________");
        System.out.println("====Введиде Cd_Id для удаления:====");
        System.out.println("______________________________________________________________");
        int delId = Integer.parseInt(scan.next());
        try{
            tx = session.beginTransaction();

            Cd delcd =(Cd) session.load(Cd.class,delId);
            session.delete(delcd);

            Criteria criteria = session.createCriteria(Cd.class);
            listCd= (List<Cd>) criteria.list();

            tx.commit();
            System.out.println("Запись удалена!!!");

        }catch ( Exception e){
            if(tx!=null){
                tx.rollback();
                System.out.println("Не корректные данные!!!");
            }
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }

    }
    public  void insertCd(){
        try {
            mFactory = HibernateUtil.getSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Couldn't create session factory." + ex);
            System.err.println("Next work unpossible!" + ex);
            System.exit(300);
        }
        try {

            System.out.println("Введите название нового альбома:");
            String album = scan.next();
            System.out.println("Введите название нового жанра:");
            String genre = scan.next();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите данные для поля Artist_id:");
            int  arts_id = Integer.parseInt(scanner.next());
            System.out.println("Введите данные для поля Oraganization_id:");
            int org_id = Integer.parseInt(scanner.next());
            try{
                session = mFactory.openSession();
                tx = session.beginTransaction();
                session.createSQLQuery("INSERT  INTO CD (Album, Genre, Artist_ID, Organization_ID) " +
                        "values('"+album+"',\'"+
                genre+"\',"+arts_id+","+org_id+")").executeUpdate();
               tx.commit();
//            System.out.println("Введите название нового альбома:");
//            String album = scan.next();
//            System.out.println("Введите название нового жанра:");
//            String genre = scan.next();
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Введите данные для поля Artist_id:");
//            int  arts_id = Integer.parseInt(scanner.next());
//            System.out.println("Введите данные для поля Oraganization_id:");
//            int org_id = Integer.parseInt(scanner.next());
//            try {
//                session = mFactory.openSession();
//                tx = session.beginTransaction();
//                Cd cd  = new Cd();
//                Artist artist = new Artist();
//                Organization organization = new Organization();
//                cd.setAlbum(album);
//                cd.setGanre(genre);
//                artist.setArtist_ID(arts_id);
//                organization.setOrganization_id(org_id);
//                session.save(cd);
//                tx.commit();
//                System.out.println("Добавлен новый CD-диск:\"" + album +"  "+genre);
            }catch (Exception e){
                if(tx!=null){
                    tx.rollback();
                }
            }finally {
                if(session != null && session.isOpen()){
                    session.close();
                }
            }
        }catch (Exception e){
            System.out.println("Некоректно введенные данные!!!");
        }
    }
    public void operationWithDB() {
        System.out.println("\n___________________________\n" +
                "Выберите дейсвтия, которое вы хотите выполнить:\n" +
                "1. Отобразить содержимое таблицы;\n" +
                "2. Удалить некоторые данные;\n" +
                "3. Отредактировать некоторые данные;\n" +
                "4. Добавить новые данные;\n" +
                "5. Вывод CD-дисков по жанру;\n" +
                "0. Выйти в главное меню.\n" +
                "____________________________");
    }
    public  void  updateCd(){
        try {
            mFactory = HibernateUtil.getSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Couldn't create session factory." + ex);
            System.err.println("Next work unpossible!" + ex);
            System.exit(300);
        }
        try {
            session = mFactory.openSession();
            tx = session.beginTransaction();
            Cd cd = new Cd();
            System.out.println("Введите ID диска которого хотите изменить:");
            int updname = Integer.parseInt(scan.nextLine());
            // String updname = scan.nextLine();
            //artist.setName(updname);
            System.out.println("Введите название нового альбома:");
            String name_alb = scan.nextLine();
            System.out.println("Введите название жанра:");
            String genre = scan.nextLine();
            cd = (Cd) session.get(Cd.class,updname);
            cd.setAlbum(name_alb);
            cd.setGanre(genre);
            session.update(cd);
            tx.commit();
            System.out.println("Данные были обновлены");
        }catch (Exception e){
            if(tx!=null){
                tx.rollback();
            }
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }
 public  void selectGenreCd(){
      try {
        mFactory = HibernateUtil.getSessionFactory();
    } catch (Throwable ex) {
        System.err.println("Couldn't create session factory." + ex);
        System.err.println("Next work unpossible!" + ex);
        System.exit(300);
    }
        try {
          try {
              System.out.println("Выборка CD-дисков по жанру");
              System.out.println("Введите название жанра:");
              String name_genre = scan.next();
              session = mFactory.openSession();
              tx = session.beginTransaction();
              Criteria criteria = session.createCriteria(Cd.class);
              criteria.add(Restrictions.eq("Genre", name_genre));
              listCd = criteria.list();
              for(Cd cd:listCd){
                  System.out.println(cd.toString());
              }
          }catch (Exception e){
              System.out.println("Введены неправельные данные или данны отсутствуют!!!");
          }
    } catch (Exception e) {
        if (tx != null) {
            tx.rollback();
        }
        e.printStackTrace();
    } finally {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
        System.out.println("=== The end session Select CD ===");
}
}