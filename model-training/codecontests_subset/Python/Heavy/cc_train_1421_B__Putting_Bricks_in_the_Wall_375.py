from sys import stdin, stdout
import math,sys,heapq
from itertools import permutations, combinations
from collections import defaultdict,deque,OrderedDict
from os import path
import random
import bisect as bi
def yes():print('YES')
def no():print('NO')
if (path.exists('input.txt')): 
    #------------------Sublime--------------------------------------#
    sys.stdin=open('input.txt','r');sys.stdout=open('output.txt','w');
    def I():return (int(input()))
    def In():return(map(int,input().split()))
else:
    #------------------PYPY FAst I/o--------------------------------#
    def I():return (int(stdin.readline()))
    def In():return(map(int,stdin.readline().split()))
#sys.setrecursionlimit(1500)
def dict(a):
    d={} 
    for x in a:
        if d.get(x,-1)!=-1:
            d[x]+=1
        else:
            d[x]=1
    return d
def find_gt(a, x):
    'Find leftmost value greater than x'
    i = bi.bisect_left(a, x)
    if i != len(a):
        return i
    else:            
        return -1
def main():
    try:
        
        n=I()
        l=[]
        for x in range(n):
            l.append(input())
        ans=[]
        if l[0][1]=='1' and l[1][0]=='1':
            if l[n-1][n-2]!='0':
                ans.append([n,n-1])
            if l[n-2][n-1]!='0':
                ans.append([n-1,n])
        elif l[0][1]=='0' and l[1][0]=='0':
            if l[n-1][n-2]!='1':
                ans.append([n,n-1])
            if l[n-2][n-1]!='1':
                ans.append([n-1,n])
        else:
            if l[0][1]=='1':
                if l[n-1][n-2]=='1' and l[n-2][n-1]=='1':
                    ans.append([1,2])
                else:
                    ans.append([2,1])
                    if l[n-2][n-1]!='0':
                        ans.append([n-1,n])
                    elif l[n-1][n-2]!='0':
                        ans.append([n,n-1])
            else:
                if l[n-2][n-1]=='0' and l[n-1][n-2]=='0':
                    ans.append([1,2])
                else:
                    ans.append([2,1])
                    if l[n-2][n-1]!='1':
                        ans.append([n-1,n])
                    elif l[n-1][n-2]!='1':
                        ans.append([n,n-1])
        print(len(ans))
        if len(ans):
            for x in ans:
                print(*x)
    except:
        pass
        
M = 998244353
P = 1000000007
 
if __name__ == '__main__':
    for _ in range(I()):main()
    #for _ in range(1):main()