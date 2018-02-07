//Java 8 Date and Time Parsing and Formatting Microtutorial

package com.jgk.csv;
public final class DateTimeFormatter
{
    private DateTimeFormatter(){}

    public static String mWorkOnDate(String mWorkOnDate)
    {
        return mWorkOnDate.parse("2016-11-03", DateTimeFormatter.ISO_LOCAL_DATE);
    }
}



/**
Instant.now();
// java.time.Instant = 2015-08-13T09:28:27.141Z

DateTimeFormatter.ISO_INSTANT.format(Instant.now());
// String = 2015-08-13T09:28:24.320Z

Instant.parse("2015-08-13T09:28:27.141Z");
// java.time.Instant = 2015-08-13T09:28:27.141Z

ZonedDateTime.now();
// java.time.ZonedDateTime = 2015-08-13T11:33:18.771+02:00[Europe/Berlin]

DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(ZonedDateTime.now());
// String = 2015-08-13T11:34:29.62+02:00

ZonedDateTime.parse("2015-08-13T11:34:29.62+02:00");
// java.time.ZonedDateTime = 2015-08-13T11:34:29.620+02:00

ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Berlin"));
// java.time.ZonedDateTime = 2015-08-13T11:43:27.128+02:00[Europe/Berlin]

DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("UTC")));
// String = 2015-08-13T09:41:43.263Z

DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Berlin")));
// String = 2015-08-13T11:41:52.185+02:00

ZonedDateTime.parse("2015-08-13T11:34:29.62+02:00");
// java.time.ZonedDateTime = 2015-08-13T11:34:29.620+02:00

ZonedDateTime.parse("2015-08-13T11:34:29.62+02:00").toInstant();
// java.time.Instant = 2015-08-13T09:34:29.620Z

LocalDate.of(2011, 12, 13);
// java.time.LocalDate = 2011-12-13

LocalDate.parse("2016-11-03", DateTimeFormatter.ISO_LOCAL_DATE);
// java.time.LocalDate = 2016-11-03

LocalDate.parse("2016-11-03", DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay().toInstant(ZoneOffset.UTC);
// java.time.Instant = 2016-11-03T00:00:00Z

DateTimeFormatter.ofPattern("yyyy/MM-dd").format(LocalDate.now());
// res4: String = 2017/03-21
*/