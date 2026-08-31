#!/usr/bin/env python3

from collections import Counter
from datetime import datetime
import re

def is_date_correct(date):
    try:
        datetime.strptime(date, "%d-%m-%Y")
        return True
    except ValueError:
        return False


def count(s, sub):
    result = 0
    for i in range(len(s) + 1 - len(sub)):
        result += (s[i:i + len(sub)] == sub)
    return result


def main():
    s = input()
    dates = Counter(filter(is_date_correct, (x.group(1) for x in re.finditer('(?=([0-3]\d-[0-1]\d-201[3-5]))', s))))
    print(dates.most_common(1)[0][0])


if __name__ == '__main__':
    main()
