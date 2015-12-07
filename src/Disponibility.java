/*
 * Programação Sistemática - Universidade de Brasília
 * Trabalho 02
 * Autores:
 *      - Adriano Torres    11/0106032
 *      - Caio Oliveira     14/0176713
 *      - Leandro Faria     14/0178759
 *      - Lisa Evaldt       09/0093450
 */
package psproject2;

/**
 * Disponibilidade. Possui campos para identificar cada variável referente à disponibilidade.
 * @author Leandro Faria
 */
public class Disponibility {
    private int year;
    private int month;
    private int day;
    private int weekDay;
    private int startTime;
    private int endTime;
    
    public Disponibility() {
        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.weekDay = 0;
        this.startTime = 0;
        this.endTime = 0;
    }
    
    /**
     * Método que preenche os dados referentes à disponilidade em questão.
     * @param info A string que contém toda e qualquer informação a respeito desta disponibilidade.
     */
    public void populateData(String info) {
        int index = 5;
        /* Fazendo a análise da String e preenchendo os dados da disponibilidade. */
        /* Os primeiros 3 caracteres sempre correspondem ao dia da semana. */
        /* Converteremos para inteiro, onde Domingo = 0 */
        String wd = info.substring(0, 3).toUpperCase();
        if (wd.equals("DOM")) this.weekDay = 1;
        if (wd.equals("SEG")) this.weekDay = 2;
        if (wd.equals("TER")) this.weekDay = 3;
        if (wd.equals("QUA")) this.weekDay = 4;
        if (wd.equals("QUI")) this.weekDay = 5;
        if (wd.equals("SEX")) this.weekDay = 6;
        if (wd.equals("SAB")) this.weekDay = 7;
        /* Se houver vírgula no restante do texto após o dia da semana, então temos uma data específica e depois a hora. */
        if (info.indexOf(",", index) != -1) {
            this.day = Integer.parseInt(info.substring(index, index + 2));
            index += 3;
            this.month = Integer.parseInt(info.substring(index, index + 2));
            index += 3;
            this.year = Integer.parseInt(info.substring(index, index + 4));
            index += 6;
        }
        /* A informação de hora deve sempre estar disponível no texto. */
        this.startTime += Integer.parseInt(info.substring(index, info.indexOf(":", index))) * 60;
        index = info.indexOf(":", index) + 1;
        this.startTime += Integer.parseInt(info.substring(index, index + 2));
        index = info.indexOf("-", index) + 1;
        this.endTime += Integer.parseInt(info.substring(index, info.indexOf(":", index))) * 60;
        index = info.indexOf(":", index) + 1;
        this.endTime += Integer.parseInt(info.substring(index, index + 2));
    }
    
    /**
     * Método que retorna o horário de início da disponibilidade. Utilizado para marcação das palestras.
     * @return Inteiro representando em minutos o horário de início da disponibilidade.
     */
    public int getStartTime() {
        return this.startTime;
    }
    
    /**
     * Método que verifica se a disponibilidade desejada bate com a disponibilidade existente.
     * @param year Ano.
     * @param month Mês.
     * @param day Dia.
     * @param dayOfWeek Dia da semana.
     * @param howLong Por quanto tempo.
     * @return Retorna verdadeiro caso seja compatível e falso em caso contrário.
     */
    public boolean match(int year, int month, int day, int dayOfWeek, int howLong) {
        /* O mês da classe Calendário começa em zero, portanto corrigimos isso. */
        month += 1;
        if ((dayOfWeek == this.weekDay) && (this.year == 0 || year == this.year) && (this.month == 0 || month == this.month) && (this.day == 0 || day == this.day) && (howLong <= this.endTime - this.startTime)) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Método para fins de debug, que imprime a disponibilidade.
     */
    public void printDisponibility() {
        System.out.println("- " + this.weekDay + ", " + this.day + "," + this.month + "," + this.year + " de " + this.startTime + "-" + this.endTime);
    }
}
