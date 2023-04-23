package app.carbooking;

import app.carbooking.entity.Location;
import app.carbooking.repository.LocationRepository;
import app.carbooking.service.LocationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationControllerTest {

    @MockBean
    LocationRepository locationRepository;

    @Mock
    Location location;
    @Autowired
    LocationService locationService;

   /* @Before
    public void setup() {

        mockMvc = MockMvcBuilders.standaloneSetup(mockMvc).build();
    }*/
    @Test
    public void testCreateLocation() throws Exception {
        location = new Location(1,"abcd","abcd","abcd","abcd","abcd","abcd");
       // Location locationService = Mockito.mock(LocationService.class);
        Mockito.when(locationRepository.save(location)).thenReturn(location);
        assertEquals(location, locationService.createLocation(location));

    }
}
