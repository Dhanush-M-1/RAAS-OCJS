from math import *
import sys, random

def nextInt():
    return int(input())
def nextStrs():
    return input().split()
def nextInts():
    return list(map(int,nextStrs()))

def main():
    n,m = nextInts()

    arr = [0]*(m+1)
    for i in range(n):
        b = nextInts()
        for i in range(1,b[0]+1):
            arr[b[i]] = 1

    ok = True
    for i in range(1,m+1):
        if arr[i] == 0:
            ok = False

    if ok:
        print("YES")
    else:
        print("NO")
    
    
if __name__ == '__main__':
    exit(main())

