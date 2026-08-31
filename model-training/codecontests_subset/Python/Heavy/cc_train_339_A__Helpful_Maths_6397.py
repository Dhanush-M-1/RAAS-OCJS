#!/usr/bin/env python3

import math
from sys import stdin, stdout


def get_int():
    return int(stdin.readline().strip())


def get_ints():
    return map(int, stdin.readline().strip().split())


def get_string():
    return stdin.readline().strip()


def get_list():
    return list(map(int, stdin.readline().strip().split()))


if __name__ == "__main__":
    s = get_string()
    s = s.replace("+", "")
    s = "".join(sorted(s))
    newS = ""
    for i in range(len(s)):
        if i == len(s) - 1:
            newS += s[i]
            break
        newS += s[i] + "+"
    stdout.write(newS)
