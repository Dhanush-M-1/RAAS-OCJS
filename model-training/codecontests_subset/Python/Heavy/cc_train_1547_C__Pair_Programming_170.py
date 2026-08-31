
import sys
#-----------------------IMPORTANT  FUNCTIONS ---------------------------------#
from math import cos, pi, ceil, pi,tan, floor, gcd, sqrt, log2, factorial, log10
from collections import Counter
from copy import deepcopy
from string import ascii_lowercase,ascii_uppercase
from statistics import mean,median,mode
alpha = ascii_lowercase
beta=ascii_uppercase
#-----------------------NEXT POWER OF 2---------------------------------------#
def nextPowerOf2(n):
    p = 1
    if (n and not(n & (n - 1))):
        return n
    while (p < n) :
        p <<= 1
    return p
#-----------------------GET DIVISORS 1 TO <=N   ------------------------------#
def get_Divisors(n) :
    arr=[]
    i = 1
    while i <= sqrt(n):
        if (n % i == 0) :
            if (n / i == i) :
                arr.append(i)
            else :
                arr.append(i)
                arr.append(n//i)
        i = i + 1
   
    return arr 
#----------------------CHECK    PRIMES-----------------------------------#
def isprime(n):
    if n==1:
        return 0;
    i=2 
    while(i*i<=n):
        if(n%i==0):
            return 0
        i+=1 
    return 1
#-----------------------PRE COMPUTED  PRIMES-----------------------------------#
def Sieve(n):
    prime = [True for i in range(n+1)]
    prime[0]=False
    prime[1]=False
    p = 2
    while (p * p <= n):
        if (prime[p] == True):
            for i in range(p * p, n+1, p):
                prime[i] = False
        p += 1
    return prime 
#-----------------------LARGER VALUE OF  X,Y,10**9+7 --------------------------#
def power(x,y,p) :    
    res = 1 
    x = x % p
    if (x == 0) :
        return 0
    while (y > 0) :
        if ((y & 1) == 1) :
            res = (res * x) % p
        y = y >> 1  
        x = (x * x) % p
    return res
#-----------------------*****CODE STARTS  HERE*****--------------------------#
# sys.stdout = open('ot.txt', 'w')
# sys.stdin = open('in.txt', 'r')
def main():
    for ttt in range(int(input())):
        s=input().strip() 
        k,n,m=map(int,input().split())
        a=list(map(int,input().split()))
        b=list(map(int,input().split()))
        ap=0  
        bp=0  
        res=[i for i in range(1,k+1)]
        ans=[]
        flag=0
        while(ap<n  or bp<m):
            if  ap<n and a[ap]==0:
                k+=1 
                ans.append(a[ap])
                ap+=1 
                res.append(k)
            elif bp <m and b[bp]==0:
                k+=1 
                res.append(k)
                ans.append(b[bp])
                bp+=1  
            elif ap<n and  a[ap]>0  and a[ap] in res:
                ans.append(a[ap])
                ap+=1 
            elif bp <m and b[bp]>0 and b[bp] in res:
                ans.append(b[bp])
                bp+=1  
            else:
                print(-1)
                flag=1
                break
        if flag==0:
            for i in range(ap,n):
                ans.append(a[i])
            for i in range(bp,m):
                ans.append(b[i])
            print(*ans)
                
        

                       
if __name__ == "__main__":
    main()