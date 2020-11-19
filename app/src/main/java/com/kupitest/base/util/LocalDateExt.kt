package com.kupitest.base.util

import com.kupitest.base.util.DateTimeFormats.FORMATTER_INCOMING
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

fun LocalDate.toString(formatter: DateTimeFormatter): String {
    return format(formatter)
}

fun String.toLocalDate(formatter: DateTimeFormatter = FORMATTER_INCOMING): LocalDate {
    return LocalDate.parse(this, formatter)
}

object DateTimeFormats {
    private const val FORMAT_INCOMING = "yyyy-MM-dd"
    private const val FORMAT_DAYS_MONTH_YEAR = "d MMMM yyyy"
    val FORMATTER_INCOMING: DateTimeFormatter = DateTimeFormatter.ofPattern(FORMAT_INCOMING)
    val FORMATTER_DAYS_MONTH_YEAR: DateTimeFormatter = DateTimeFormatter.ofPattern(FORMAT_DAYS_MONTH_YEAR)
}