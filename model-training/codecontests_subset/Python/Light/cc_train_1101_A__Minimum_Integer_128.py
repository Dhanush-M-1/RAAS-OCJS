from sys import stdin, stdout
from math import *
from heapq import *
from collections import *

def main():
    q=int(stdin.readline())
    for _ in range(q):
        l,r,d=[int(x) for x in stdin.readline().split()]
        res=0
        if (d<l):
            res=d
        else:
            res=(trunc(r/d)+1)*d
        stdout.write(str(res)+"\n")
    return 0

if __name__ == "__main__":
    main()