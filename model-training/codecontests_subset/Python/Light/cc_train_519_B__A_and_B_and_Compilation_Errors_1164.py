#!/usr/bin/pypy3

from sys import stdin,stderr
from collections import Counter

def readInts(): return map(int,stdin.readline().strip().split())
def print_err(*args,**kwargs): print(*args,file=stderr,**kwargs)
    
def run():
    n, = readInts()
    err1 = Counter(readInts())
    err2 = Counter(readInts())
    err3 = Counter(readInts())
    print((err1-err2).popitem()[0])
    print((err2-err3).popitem()[0])

run()
