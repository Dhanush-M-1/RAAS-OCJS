#!/usr/bin/env python3

from sys import stdin
from collections import defaultdict


def main():
    _, = stdin_get_ints_from_line()
    s = stdin_get_string_from_line()

    t = defaultdict(int)

    for x in range(1, len(s)):
        t[s[x-1] + s[x]] += 1

    print(max(t, key=t.get))



def stdin_get_ints_from_line():
    return (int(x) for x in stdin.readline().strip().split(' '))


def stdin_get_ints_list_from_line():
    return list(int(x) for x in stdin.readline().strip().split(' '))


def stdin_get_string_from_line():
    return stdin.readline().strip()


if __name__ == '__main__':
    main()
