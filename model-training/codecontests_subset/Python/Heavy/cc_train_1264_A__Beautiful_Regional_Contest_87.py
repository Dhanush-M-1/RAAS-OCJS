#!/usr/bin/env python3
# coding: utf-8
# Last Modified: 06/Dec/19 10:08:00 AM


import sys


def main():
    from collections import Counter

    for tc in range(int(input())):
        n = int(input())
        arr = get_array()
        x = arr[n // 2]
        arr = arr[: n // 2]
        n = len(arr)
        if n <= 2:
            print(0, 0, 0)
            continue

        g, s, b = 0, 0, 0
        g += 1
        i = 1

        while i < len(arr) and arr[i] == arr[0]:
            i += 1
            g += 1
        j = i
        if i == len(arr):
            print(0, 0, 0)
            continue
        while i < len(arr) and (arr[i] == arr[j] or s <= g):
            j = i
            s += 1
            i += 1
        if i == len(arr):
            print(0, 0, 0)
            continue
        j = i
        p = arr[i]
        while i < len(arr) and (arr[i] > x or arr[i] == arr[j] or b <= g):
            p = arr[i]
            j = i
            b += 1
            i += 1
        if x == p:
            print(0, 0, 0)
            continue

        if g >= b or g >= s:
            print(0, 0, 0)
        else:
            print(g, s, b)


get_array = lambda: list(map(int, sys.stdin.readline().split()))


get_ints = lambda: map(int, sys.stdin.readline().split())


input = lambda: sys.stdin.readline().strip()


if __name__ == "__main__":
    main()
