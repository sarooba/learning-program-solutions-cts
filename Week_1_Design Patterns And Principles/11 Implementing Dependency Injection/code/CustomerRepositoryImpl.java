public class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(int id) {
        return "Customer with ID " + id + " is Arjun.";
    }
}
