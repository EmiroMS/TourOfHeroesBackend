package co.udea.api.hero;
import co.udea.api.hero.controller.HeroController;
import co.udea.api.hero.model.Hero;
import co.udea.api.hero.service.HeroService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import co.udea.api.hero.model.Hero;
import co.udea.api.hero.service.HeroService;

@RunWith(MockitoJUnitRunner.class)
public class HeroControllerTest {

    private HeroController heroController;

    @Mock
    private HeroService heroService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        heroController = new HeroController(heroService);
    }

    @Test
    public void createHeroTest() {
        Hero hero = new Hero(1, "Superman");
        when(heroService.createHero(any(Hero.class))).thenReturn(hero);

        ResponseEntity<Hero> responseEntity = heroController.createHero(hero);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(hero, responseEntity.getBody());
    }
}
