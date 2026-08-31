#!/usr/bin/env python3
# -*- coding: utf-8 -*-


def main():
    pw = input()
    n = int(input())

    match = False
    words = []
    for i in range(n):
        w = input()
        words.append(w);

    ca = 0
    cb = 0
    for w in words:
        if w == pw:
            match = True
        else:
            if w[0] == pw[1]:
                ca += 1
            if w[1] == pw[0]:
                cb += 1

    if match or (ca > 0 and cb > 0):
        print("YES")
    else:
        print("NO")


if __name__ == '__main__':
    main()

# eof

