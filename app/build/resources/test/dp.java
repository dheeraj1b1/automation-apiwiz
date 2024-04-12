import org.testng.annotations.DataProvider;

public class dp {
    
    @DataProvider(name = "userData")
    public Object[][] userDataCredentials() {
        return new Object[][] { 
            { "apiwizItorix", "Apiwiz@123" },
        };
    }
}
