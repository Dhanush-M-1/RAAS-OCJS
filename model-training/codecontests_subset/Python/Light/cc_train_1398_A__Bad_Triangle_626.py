from math import *
import sys, random

def nextInt():
    return int(input())
def nextStrs():
    return input().split()
def nextInts():
    return list(map(int,nextStrs()))

def can(i,j,k):
    if i+j > k:
        return True
    return False

def main():
    t = nextInt()

    while t > 0:
        n = nextInt()
        arr = nextInts()

        if can(arr[0],arr[1],arr[n-1]):
            print(-1)
        else:
            print(1,2,n)
        

        t-=1
    
if __name__ == '__main__':
    exit(main())
