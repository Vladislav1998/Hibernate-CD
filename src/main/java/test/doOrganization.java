package test;
import entities.Organization;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.omg.PortableInterceptor.INACTIVE;
import sun.applet.Main;
import java.util.List;
import java.util.Scanner;
public class doOrganization {
    Session session = null;
    Transaction tx = null;
    Long testID = null;
    List<Organization> listOrg = null;
    SessionFactory mFactory = null;
    Scanner scan = new Scanner(System.in);

    public  void selectOrg() {
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
            Criteria criteria = session.createCriteria(Organization.class);
            listOrg = (List<Organization>) criteria.list();
            tx.commit();
            System.out.println("\n\n Данные с таблицы Organization:");
            for (Organization org : listOrg) {
                System.out.println(org.toString());
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
        System.out.println("=== The end session Select Organization ===");
    }
    public  void deleteOrg(){
        try {
            mFactory = HibernateUtil.getSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Couldn't create session factory." + ex);
            System.err.println("Next work unpossible!" + ex);
            System.exit(300);
        }
        listOrg = null;
        session = mFactory.openSession();
        tx = null;
        System.out.println("______________________________________________________________");
        System.out.println("====Введиде Organization_Id для удаления:====");
        System.out.println("______________________________________________________________");
        int delId = Integer.parseInt(scan.next());
        try{
            tx = session.beginTransaction();

            Organization delOrg =(Organization) session.load(Organization.class,delId);
            session.delete(delOrg);

            Criteria criteria = session.createCriteria(Organization.class);
            listOrg= (List<Organization>) criteria.list();

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
    public  void insertOrg(){
        try {
            mFactory = HibernateUtil.getSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Couldn't create session factory." + ex);
            System.err.println("Next work unpossible!" + ex);
            System.exit(300);
        }
        try {
            System.out.println("Введите название новой организации:");
            String name = scan.next();
            System.out.println("Введитеномер телефона организации:");
            String phone =scan.next();
            System.out.println("Введите E_mail организации");
            String mail =scan.next();
            try {
                session = mFactory.openSession();
                tx = session.beginTransaction();
                Organization organization = new Organization();
                organization.setName_of_organization(name);
                organization.setPhone(phone);
                organization.setE_mail(mail);
                session.save(organization);
                tx.commit();
                System.out.println("Добавленa новая организация:\"" + name +"  "+phone+"   "+mail);
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
    public  void  updateOrg(){
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
            Organization organization = new Organization();
            System.out.println("Введите ID orzanization которого хотите изменить:");
            int updname = Integer.parseInt(scan.nextLine());
            // String updname = scan.nextLine();
            //artist.setName(updname);
            System.out.println("Введите название новой организации:");
            String name = scan.nextLine();
            System.out.println("Введите номер телефона:");
            String  phone = scan.nextLine();
            System.out.println("Введите E_mail организации:");
            String  mail = scan.nextLine();
            organization = (Organization) session.get(Organization.class,updname);
            System.out.println("name as:"+organization.getName_of_organization());
            organization.setName_of_organization(name);
            organization.setPhone(phone);
            organization.setE_mail(mail);
            session.update(organization);
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


