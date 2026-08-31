from collections import deque, Counter, OrderedDict
from heapq import nsmallest, nlargest
from math import ceil,floor,log,log2,sqrt,gcd,factorial
def binNumber(n,size=1):
    return bin(n)[2:].zfill(size)

def iar():
    return list(map(int,input().split()))

def ini():
    return int(input())

def isp():
    return map(int,input().split())

def sti():
    return str(input())



if __name__ == "__main__":
    s = sti()
    count = [0] * 5
    cnt=0
    for c in s:
        if c != '+':
            count[int(c)]+=1
        else:
             cnt+=1
    
    for i in range(1,4):
        j= count[i]
        for k in range(1,j+1):
            print(str(i) , end='')
            if cnt :
                print('+',end='')
                cnt-=1
        


