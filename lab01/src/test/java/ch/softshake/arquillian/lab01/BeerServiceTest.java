package ch.softshake.arquillian.lab01;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BeerServiceTest
{

   @Test
   public void should_find_all_beers() throws Exception
   {
      // given
      final BeerRepository mockedBeerRepository = mock(BeerRepository.class);
      when(mockedBeerRepository.findAll()).thenReturn(twoBeers());
      final BeerService beerService = new BeerService(mockedBeerRepository);

      // when
      final Collection<Beer> beers = beerService.findAll();

      // then
      assertThat(beers).hasSize(2);
   }

   private List<Beer> twoBeers()
   {
      return Arrays.asList(new Beer("Appenzeller Vollmond", BigDecimal.valueOf(3.5), BigDecimal.valueOf(5.2)),
            new Beer("Appenzeller Weizenbier", BigDecimal.valueOf(3.5), BigDecimal.valueOf(5)));
   }

}
