# The Soundex Name Lookup System

## Overview

The Soundex Name Lookup System is a Java program designed to assist researchers in searching for individuals within census records, particularly those maintained by the United States National Archives. The program utilizes the Soundex phonetic system to generate Soundex keys for names, making it easier for researchers to find individuals with similar sounding names.

## Soundex Rules

1. The entire name is translated into a series of digit characters according to the following rules:
    * b, p, f, v → '1'
    * c, s, k, g, j, q, x, z → '2'
    * d, t → '3'
    * l → '4'
    * m, n → '5'
    * r → '6'
    * all other letters → '7'

    Example: "Briggs" becomes "167222".

2. Double digits are not copied again. For example, "167222" becomes "162".

3. The first digit is replaced with the first letter of the original name in uppercase. For example, "1672" becomes "B62".

4. The resulting string is always four characters. If shorter than 4 characters, it is padded with '0's. For example, "B62" becomes "B620".

## Program Functionality

The program reads names from a file, generates a TreeMap, and indexes the keys by Soundex keys. The values in the TreeMap are TreeSet collections that store all names sharing the same Soundex key. The program outputs the Soundex key and associated names to the console and also writes the results to a new file.

## Example Usage
java SoundexNameLookupSystem name15k.txt soundex_names_file.txt
    * 'name15k.txt': File containing names to be processed.
    * 'soundex_names_file.txt': File to store the program's output.

## Sample Output
KEY: A100
NAMES: ACUFF ALBA ALBEE ALVA ALVEY ARP ASHBY 