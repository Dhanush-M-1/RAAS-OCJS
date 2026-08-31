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
def printDivisors(n) : 
      
    # Note that this loop runs till square root 
    i = 1
    ans1=[]
    while i <= math.sqrt(n): 
          
        if (n % i == 0) : 
              
            # If divisors are equal, print only one 
            if (n / i == i) : 
                ans1.append(i) 
            else : 
                # Otherwise print both 
                ans1.append(i)
                ans1.append(n//i)
        i = i + 1
    return(ans1)
def gcd(a, b):
    while b:
        a, b = b, a % b
    return a
def lcm(a, b):
    w = a // gcd(a, b)
    return w * b
def main():
    try:
        for _ in range(1):
            n=I()
            l=printDivisors(n)
            l.sort()
            n1=len(l)
            #print(l)
            ans=[1,1]
            for x in range(len(l)//2):
                t1,t2=l[n1-x-1],l[x]
                if lcm(t1,t2)==n:
                    if ans[-1]==1:
                        ans[0]=t2
                        ans[-1]=t1
                    elif t1<ans[-1]:
                        ans[0]=t2
                        ans[-1]=t1


            if len(ans)==1:
                print(ans[0],ans[0])
            else:
                print(ans[0],ans[-1])
 
    except:
        pass
        
M = 998244353
P = 1000000007
 
if __name__ == '__main__':
    main()