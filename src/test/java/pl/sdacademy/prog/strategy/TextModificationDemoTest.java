package pl.sdacademy.prog.strategy;

import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class TextModificationDemoTest {


    @Mock
    private CustomCommandLineParser customCommandLineParser;

    @Mock
    private FileContentReader fileContentReader;

    @Mock
    private TextModificationStrategySelector strategySelector;

    @InjectMocks //tworzy konstruktor
    private TextModificationProcessFacade facade;

    @Test
    void shouldProcessTextModification() throws ParseException {
        //given
        final String[] args = {"doesNotMatter", "thisValueReallyDoesNotMatter"};
        doNothing().when(customCommandLineParser).parse(args); //mockowanie czegos co zwraca voida
        when(customCommandLineParser.getTypeOptionValue()).thenReturn(Optional.of("someType"));
        when(customCommandLineParser.getFileOptionValue()).thenReturn(Optional.of("someFilePath"));

        final TextModificationStrategy strategy = NoOpModificationStrategy.getInstance();
        when(strategySelector.getTextModificationStrategy("someType"))
                .thenReturn(strategy);
        when(fileContentReader.readContent("someFilePath")).thenReturn("someFileContent");

        //when
        final String output = facade.process(args);
        //then
        assertThat(output).isEqualTo("someFileContent");


    }
}