from sys import stdin, stdout
import math,sys
from itertools import permutations, combinations
from collections import defaultdict,deque,OrderedDict
import bisect as bi
import heapq 

'''
#------------------PYPY FAst I/o--------------------------------#
 
def I():return (int(stdin.readline()))
def In():return(map(int,stdin.readline().split()))
'''
#------------------Sublime--------------------------------------#
 
#sys.stdin=open('input.txt','r');sys.stdout=open('output.txt','w');
def I():return (int(input()))
def In():return(map(int,input().split()))


def main():
    try:
        n=I()
        l=list(input())
        d={}
        d1=set()
        for x in l:
            d1.add(x)
            if d.get(x,0)!=0:
                d[x]+=1
            else:
                d[x]=1
        if n==1:
            print(''.join(l))

        elif len(l)%n!=0:
            print(-1)
        else:
            t=len(l)//n
            lapa=[]
            flag=0
            for x in d.keys():
                if d[x]%n==0:
                    for i in range(d[x]//n):
                        lapa.append(x)
                else:
                    flag=1
            ans=""
            if flag==1:
                print(-1)
            else:
                #print(lapa)
                for i in range(n):
                    ans+=(''.join(lapa))
                print(ans)


    except:
        pass
        
M = 998244353
P = 1000000007
 
if __name__ == '__main__':
    for _ in range(1):
        main()