from math import *
import random, sys

def nextInt():
	return int(input())
def nextStrs():
	return input().split()
def nextInts():
	return list(map(int,nextStrs()))

def main():
    n = nextInt()
    arr = nextInts()
    
    arr.sort()

    res = 10**9+7; cnt = 0
    for i in range(len(arr)):
        cnt += abs(arr[i]-2*(i+1))
    
    res = min(res,cnt); cnt = 0

    for i in range(len(arr)):
        cnt += abs(arr[i]-2*i-1)
            
    res = min(res,cnt)

    print(res)

if __name__ == "__main__":
    exit(main())