package test;

import entities.Artist;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.omg.PortableInterceptor.INACTIVE;
import sun.applet.Main;
import java.util.List;
import java.util.Scanner;
public class doArtist {
    Session session = null;
    Transaction tx = null;
    Long testID = null;
    List<Artist> listArt = null;
    SessionFactory mFactory = null;
    Scanner scan = new Scanner(System.in);

    public  void selectArtist() {

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
            Criteria criteria = session.createCriteria(Artist.class);
            listArt = (List<Artist>) criteria.list();
            tx.commit();
            System.out.println("\n\n Данные с таблицы Artist:");
            for (Artist cd : listArt) {
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
        System.out.println("=== The end session Select Artist ===");
    }
    public  void deleteArtist(){
        try {
            mFactory = HibernateUtil.getSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Couldn't create session factory." + ex);
            System.err.println("Next work unpossible!" + ex);
            System.exit(300);
        }
        listArt = null;
        session = mFactory.openSession();
        tx = null;
        System.out.println("______________________________________________________________");
        System.out.println("====Введиде Artist_Id для удаления:====");
        System.out.println("______________________________________________________________");
            int delId = Integer.parseInt(scan.next());
        try{
            tx = session.beginTransaction();

            Artist delArtist =(Artist) session.load(Artist.class,delId);
            session.delete(delArtist);

            Criteria criteria = session.createCriteria(Artist.class);
            listArt = (List<Artist>) criteria.list();

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
        public  void insertArtist(){
            try {
                mFactory = HibernateUtil.getSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Couldn't create session factory." + ex);
                System.err.println("Next work unpossible!" + ex);
                System.exit(300);
            }
            try {
            System.out.println("Введите имя нового артиста:");
            String name = scan.next();
            System.out.println("Введите количетво его альбомов:");
            int album = Integer.parseInt( scan.next());
            try {
                 session = mFactory.openSession();
                 tx = session.beginTransaction();
                 Artist artist = new Artist();
                 artist.setName(name);
                 artist.setNumber_of_albums(album);
                 session.save(artist);
                 tx.commit();
                System.out.println("Добавлен новый Артист:\"" + name +"  "+album);
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
     public  void  updateArtist(){
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
                Artist artist = new Artist();
                 System.out.println("Введите ID артиста которого хотите изменить:");
                 int updname = Integer.parseInt(scan.nextLine());
                // String updname = scan.nextLine();
                 //artist.setName(updname);
                 System.out.println("Введите имя нового артиста:");
                 String name = scan.nextLine();
                 System.out.println("Введите количетво его альбомов:");
                 int album = Integer.parseInt( scan.nextLine());
                 artist = (Artist) session.get(Artist.class,updname);
                 System.out.println("name as:"+artist.getName());
                 artist.setName(name);
                 artist.setNumber_of_albums(album);
                 session.update(artist);
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
       /*  public void MenuArtist(){
             Scanner scanner = new Scanner(System.in);
             String select ="";
             operationWithDB();
             while (!select.equals("0")){
                 System.out.println("Action Number:");
                 select=scanner.nextLine();
                 switch (select) {
                     case "1":
                         selectArtist();
                         operationWithDB();
                         break;
                     case "2":
                         selectArtist();
                         deleteArtist();
                         operationWithDB();
                         break;
                     case "3":
                         selectArtist();
                         updateArtist();
                         operationWithDB();
                         break;
                     case "4":
                         selectArtist();
                         insertArtist();
                         operationWithDB();
                         break;
                     case "0":
                         main.MainMenu();
                         break;
                     default:
                         break;

         }

             }
     }*/
public void operationWithDB(){
        System.out.println("\n___________________________\n" +
                "Выберите дейсвтия, которое вы хотите выполнить:\n" +
                "1. Отобразить содержимое таблицы;\n" +
                "2. Удалить некоторые данные;\n" +
                "3. Отредактировать некоторые данные;\n" +
                "4. Добавить новые данные;\n" +
                "0. Выйти в главное меню.\n" +
                "____________________________");
       }
     }

