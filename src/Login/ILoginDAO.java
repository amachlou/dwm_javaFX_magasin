package Login;

public interface ILoginDAO<Login> {

	public Login getOne(String user,String password);
}
