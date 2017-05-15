package com.eltiempo.ceetchat.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Formats {

    private static final String UTF_8 = "UTF-8";

    private static final String IQUEST = "&iquest;";

    private static final String NTILDE2 = "&ntilde;";

    private static final String NTILDE = "&Ntilde;";

    private static final String UACUTE2 = "&uacute;";

    private static final String UACUTE = "&Uacute;";

    private static final String OACUTE2 = "&oacute;";

    private static final String OACUTE = "&Oacute;";

    private static final String IACUTE2 = "&iacute;";

    private static final String IACUTE = "&Iacute;";

    private static final String EACUTE2 = "&eacute;";

    private static final String EACUTE = "&Eacute;";

    private static final String AACUTE2 = "&aacute;";

    private static final String AACUTE = "&Aacute;";

    private static final String AMP = "&amp;";

    private static final String GT = "&gt;";

    private static final String LT = "&lt;";

    private static final String RSQUO = "&rsquo;";

    private static final String QUOT = "&quot;";

    private static final String AA_EE_II_OO_UU_YY = "AaEeIiOoUuYy";

    private static final String AA_EE_II_OO_UU = "AaEeIiOoUu";

    private static final Integer DIAS_ANYOS = 365;

    private static final Logger LOGGER = LoggerFactory.getLogger(Formats.class);

    private static final String UNICODE = "\u00C0\u00E0\u00C8\u00E8" + "\u00CC\u00EC\u00D2\u00F2\u00D9\u00F9"
            + "\u00C1\u00E1\u00C9\u00E9\u00CD\u00ED\u00D3\u00F3\u00DA\u00FA\u00DD\u00FD"
            + "\u00C2\u00E2\u00CA\u00EA\u00CE\u00EE\u00D4\u00F4\u00DB\u00FB\u0176\u0177" + "\u00C3\u00E3\u00D5\u00F5\u00D1\u00F1"
            + "\u00C4\u00E4\u00CB\u00EB\u00CF\u00EF\u00D6\u00F6\u00DC\u00FC\u0178\u00FF" + "\u00C5\u00E5" + "\u00C7\u00E7"
            + "\u0150\u0151\u0170\u0171";

    private static final String PLAIN_ASCII = AA_EE_II_OO_UU + AA_EE_II_OO_UU_YY + AA_EE_II_OO_UU_YY + "AaOoNn" + AA_EE_II_OO_UU_YY + "Aa" + "Cc"
            + "OoUu";

    /**
     * Replace single quotes characters with HTML entities.
     *
     * @param str the input string
     * @return string with replaced single quotes
     */
    public static String htmlSingleQuotes(String str) {
        return str.replaceAll("[\']", RSQUO).replaceAll("&#039;", RSQUO).replaceAll("&#145;", RSQUO).replaceAll("&#146;", RSQUO);

    }

    /**
     * Replace single quotes HTML entities with equivalent character.
     *
     * @param str the input string
     * @return string with replaced single quotes
     */
    public static String unhtmlSingleQuotes(String str) {
        return str.replaceAll(RSQUO, "\'");
    }

    /**
     * Replace double quotes characters with HTML entities.
     *
     * @param str the input string
     * @return string with replaced double quotes
     */
    public static String htmlDoubleQuotes(String str) {
        return str.replaceAll("[\"]", QUOT).replaceAll("&#147;", QUOT).replaceAll("&#148;", QUOT);

    }

    /**
     * Replace single quotes HTML entities with equivalent character.
     *
     * @param str the input string
     * @return string with replaced single quotes
     */
    public static String unhtmlDoubleQuotes(String str) {
        return str.replaceAll(QUOT, "\"");
    }

    /**
     * Replace single and double quotes characters with HTML entities.
     *
     * @param str the input string
     * @return string with replaced quotes
     */
    public static String htmlQuotes(String str) {
        String newStr = htmlDoubleQuotes(str); // convert double quotes
        newStr = htmlSingleQuotes(newStr); // convert single quotes
        return newStr;
    }

    /**
     * Replace single and double quotes HTML entities with equivalent characters.
     *
     * @param str the input string
     * @return string with replaced quotes
     */
    public static String unhtmlQuotes(String str) {
        String newStr = unhtmlDoubleQuotes(str); // convert double quotes
        newStr = unhtmlSingleQuotes(newStr); // convert single quotes
        return newStr;
    }

    /**
     * Replace &lt; &gt; characters with &amp;lt; &amp;gt; entities.
     *
     * @param str the input string
     * @return string with replaced characters
     */
    public static String htmlAngleBrackets(String str) {
        return str.replaceAll("<", LT).replaceAll(">", GT);

    }

    /**
     * Replace &amp;lt; &amp;gt; entities with &lt; &gt; characters.
     *
     * @param str the input string
     * @return string with replaced entities
     */
    public static String unhtmlAngleBrackets(String str) {
        return str.replaceAll(LT, "<").replaceAll(GT, ">");

    }

    /**
     * Replace &amp; characters with &amp;amp; HTML entities.
     *
     * @param str the input string
     * @return string with replaced characters
     */
    public static String htmlAmpersand(String str) {
        return str.replaceAll("&", AMP);
    }

    /**
     * Replace &amp;amp; HTML entities with &amp; characters.
     *
     * @param str the input string
     * @return string with replaced entities
     */
    public static String unhtmlAmpersand(String str) {
        return str.replaceAll(AMP, "&");
    }

    public static String gatDays(Date fechaInicio, Date fechaFin) {

        String rst = "";

        GregorianCalendar calendarAhora = new GregorianCalendar();
        calendarAhora.setTime(fechaFin);
        GregorianCalendar calendarInicio = new GregorianCalendar();
        calendarInicio.setTime(fechaInicio);

        try {
            int rangoAnyos = calendarAhora.get(Calendar.YEAR) - calendarInicio.get(Calendar.YEAR);
            int total = (rangoAnyos * DIAS_ANYOS) + (calendarAhora.get(Calendar.DAY_OF_YEAR) - calendarInicio.get(Calendar.DAY_OF_YEAR));
            rst = total == 1 ? total + " d&iacute;a" : total > 30 ? "M&aacute;s de 30 d&iacute;as" : total + " d&iacute;as";
        } catch (Exception e) {
            LOGGER.error("error get days", e);
        }

        return rst;
    }

    public static int gatCountDays(Date fechaInicio, Date fechaFin) {
        if (fechaInicio != null && fechaFin != null) {
            GregorianCalendar calendarAhora = new GregorianCalendar();
            calendarAhora.setTime(fechaFin);
            GregorianCalendar calendarInicio = new GregorianCalendar();
            calendarInicio.setTime(fechaInicio);
            int rangoAnyos = calendarAhora.get(Calendar.YEAR) - calendarInicio.get(Calendar.YEAR);
            return (rangoAnyos * DIAS_ANYOS) + (calendarAhora.get(Calendar.DAY_OF_YEAR) - calendarInicio.get(Calendar.DAY_OF_YEAR));

        } else {
            return 0;
        }

    }

    public static String readURL(String ruta) throws IOException {
        URL url = new URL(ruta);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }

    public static Long getNumberString(String cadena) {
        Pattern numerosPattern = Pattern.compile("\\d+");
        Long nro = 0L;
        String rst = "";
        if (cadena != null) {
            Matcher m = numerosPattern.matcher(cadena);
            while (m.find()) {
                rst += m.group();
            }
            if (!rst.isEmpty()) {
                nro += Long.parseLong(rst);
            }

        }
        return nro;
    }

    public static int rgetNumberStringToInt(String cadena) {
        Pattern numerosPattern = Pattern.compile("\\d+");
        int nro = 0;
        String rst = "";
        if (cadena != null) {
            Matcher m = numerosPattern.matcher(cadena);
            while (m.find()) {
                rst += m.group();
            }
            if (!rst.isEmpty()) {
                nro += Integer.parseInt(rst);
            }

        }
        return nro;
    }

    public static String decodeHtmlISO88591(String cadena) {

        return cadena.replaceAll(AACUTE, "\u00C1").replaceAll(AACUTE2, "\u00E1").replaceAll(EACUTE, "\u00C9").replaceAll(EACUTE2, "\u00E9")
                .replaceAll(IACUTE, "\u00CD").replaceAll(IACUTE2, "\u00ED").replaceAll(OACUTE, "\u00D3").replaceAll(OACUTE2, "\u00F3")
                .replaceAll(UACUTE, "\u00DA").replaceAll(UACUTE2, "\u00FA").replaceAll(NTILDE, "\u00D1").replaceAll(NTILDE2, "\u00F1")
                .replaceAll(IQUEST, "\u00bf");

    }

    public String decodeToNORMAL(String cadena) {

        return cadena.replaceAll(AACUTE, "A").replaceAll(AACUTE2, "a").replaceAll(EACUTE, "E").replaceAll(EACUTE2, "e").replaceAll(IACUTE, "I")
                .replaceAll(IACUTE2, "i").replaceAll(OACUTE, "O").replaceAll(OACUTE2, "o").replaceAll(UACUTE, "U").replaceAll(UACUTE2, "u")
                .replaceAll(NTILDE, "N").replaceAll(NTILDE2, "n");

    }

    public String formatMilesNumber(Long valor) {
        String rst = "";

        if ((valor != null) && (valor.longValue() > 0L)) {

            DecimalFormat num = new DecimalFormat("#,###");
            rst = num.format(valor);
        }

        return rst;
    }

    public static boolean validateFormat(String input, String regex) {
        Pattern pattern = null;
        Matcher mat = null;
        boolean match = false;

        pattern = Pattern.compile(regex);
        mat = pattern.matcher(input);
        match = mat.matches();
        return match;
    }

    public static String dateTostring(Date date) {
        String formato = "dd/MM/yy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(formato);

        return dateFormat.format(date);

    }


    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Entry<T, E> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static String cambiarNombreArchivo(String nombreArchivo, String adicion) {
        String nombreNuevo;
        String ext = nombreArchivo.substring(nombreArchivo.indexOf('.'), nombreArchivo.length());

        nombreNuevo = nombreArchivo.substring(0, nombreArchivo.indexOf('.'));
        nombreNuevo = nombreNuevo + "_" + adicion + ext;
        return nombreNuevo;
    }

    public static String removeSpecialChars(String string) {
        return string.replaceAll("\\?", "").replaceAll("\\$", "").replaceAll("\\%", "").replaceAll("\\#", "").replaceAll("\\~", "")
                .replaceAll("/", "").replaceAll("|", "").replaceAll("'", "").replaceAll("\\(", "").replaceAll("\\)", "");

    }

    public static String convertNonAscii(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int pos = UNICODE.indexOf(c);
            if (pos > -1) {
                sb.append(PLAIN_ASCII.charAt(pos));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String normalizeText(String name) {

        String newName = decodeHtmlISO88591(name);
        newName = newName.toUpperCase();
        newName = newName.trim();
        newName = newName.replaceAll(" ", "_").replaceAll(",", "").replaceAll("[.]", "").replaceAll(":", "").replaceAll("\"", "").replaceAll("'", "")
                .replaceAll("=", "").replaceAll("\\?", "").replaceAll("\\*", "").replaceAll("\\+", "").replaceAll("!", "").replaceAll("\\{", "")
                .replaceAll("\\}", "").replaceAll("\\[", "").replaceAll("\\]", "");

        newName = removeSpecialChars(newName);
        return convertNonAscii(newName).toLowerCase();

    }

    public static boolean isNumber(String valor) {
        if (Pattern.matches("^\\d+$", valor)) {
            return true;
        }
        return false;
    }

    /**
     * Devuelve las palabras con la primera en mayuscula
     *
     * @param text
     * @return
     */
    public static String capitalize(String text) {
        if (text != null && !text.isEmpty()) {
            char[] stringArray = text.toLowerCase().toCharArray();
            stringArray[0] = Character.toUpperCase(stringArray[0]);
            return new String(stringArray);
        }
        return "";

    }

    // Convierte de UTF-8 TO UTF-8
    public static String convertFromUTF8(String s) {
        String out = null;
        try {
            out = new String(s.getBytes(UTF_8), UTF_8);
        } catch (java.io.UnsupportedEncodingException e) {
            return null;
        }
        return out;
    }

    // convert from internal Java String format -> UTF-8
    public static String convertToUTF8(String s) {
        String out = null;
        try {
            out = new String(s.getBytes(UTF_8), UTF_8);
        } catch (java.io.UnsupportedEncodingException e) {
            return null;
        }
        return out;
    }

    /**
     * Extrae el mes de un date
     * @param date
     */
    public static int getMes(Date date) {
        String formato = "MM";
        SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
        return Integer.parseInt(dateFormat.format(date));
    }

    /**
     * Extrae el anio de un date
     * @param date
     */
    public static int getAnio(Date date) {
        String formato = "yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
        return Integer.parseInt(dateFormat.format(date));
    }

    /**
     *
     * @author gerqui
     * @param str string with character to convert
     * @return string whit character encoded UTF-8
     */
    public static String convertFormatToISO88591(String str) {

        String cadena = "";

        if (str != null && (str != "")) {
            try {
                cadena = new String(str.getBytes(UTF_8));

            } catch (UnsupportedEncodingException e) {

                LOGGER.error("convertFormatToISOISO88591 ", e);
            }
        }

        return cadena;
    }

    /**
     *
     * @param str
     * @return
     */
    public static String convertFormatISO88591ToUTF8(String str) {

        String stringUTF8 = "";
        if (str != null && !str.isEmpty()) {
            byte[] arrayByteAux;
            try {
                arrayByteAux = str.getBytes(UTF_8);
                stringUTF8 = new String(arrayByteAux, UTF_8);
            } catch (UnsupportedEncodingException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return stringUTF8;
    }

    public static String generateRandomText(int longitud) {
        String rst = "";
        int[][] letras = new int[3][2];
        letras[0][0] = 97;
        letras[0][1] = 122;
        letras[1][0] = 65;
        letras[1][1] = 90;
        letras[2][0] = 48;
        letras[2][1] = 57;
        Random r = new Random();
        for (int i = 0; i < longitud; i++) {
            int fila = r.nextInt(letras.length);
            rst += Character.toString((char) ((Math.random() * (letras[fila][1] - letras[fila][0])) + letras[fila][0]));
        }
        LOGGER.info("generarTextoAleatorio " + rst);
        return rst;
    }

}