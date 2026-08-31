from sys import stdin, stdout  
import collections
import heapq
import itertools
import functools
import math
import operator
import string

ALPHABET = string.ascii_lowercase
DIGITS = string.digits

def read_line():
    return stdin.readline().strip()
def read_int():
    return int(read_line())
def read_arr():
    return read_line().split(' ')
def read_int_arr():
    return [int(x) for x in read_arr()]
def query_interactive(s):
    print(s)
    stdout.flush()

def solve():
    n = read_int()
    s = read_line()
    oc, zc = 0, 0
    for c in s:
        if c == '0':
            zc += 1
        else:
            oc += 1
    if oc == zc:
        print(2)
        print(s[0], s[1:])
    else:
        print(1)
        print(s)

def main():
    T = 1
    # T = read_int()
    for _ in range(T):
        solve()

if __name__ == "__main__":
    main()