from sys import stdin, stdout
import math,sys
from itertools import permutations, combinations
from collections import defaultdict,deque,OrderedDict
from os import path
import bisect as bi
import heapq 
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


def main():
    try:
        n,k=In()
        l1,l2,l3=[],[],[]
        for x in range(n):
            t,a,b=In()
            if a==1 and b==1:
                l1.append(t)
            elif a==0 and b==1:
                l3.append(t)
            elif a==1 and b==0:
                l2.append(t)
            else:
                continue
        #l1.sort()
        l2.sort()
        l3.sort()
        l4=[]
        #print(l2)
        if len(l2)<len(l3):
            for x in range(len(l2)):
                l4.append(l2[x]+l3[x])
        elif len(l2)>=len(l3) and len(l2)!=0:
            for x in range(len(l3)):
                l4.append(l2[x]+l3[x])
        l1+=l4
        if k>len(l1):
            print(-1)
        else:
            ans=0
            l1.sort()
            for x in range(k):
                ans+=l1[x]
            print(ans)


        
    except:
        pass
        
M = 998244353
P = 1000000007
 
if __name__ == '__main__':
    #for _ in range(I()):main()
    for _ in range(1):main()