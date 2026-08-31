import sys
#from collections import defaultdict
#from collections import Counter
#import math
#from fractions import Fraction
#import heapq
#from bisect import bisect_left

def main():
    mod=998244353
    def GCD(x, y):
        while (y):
            x, y = y, x % y
        return x
    def lcm(a,b):
        return (a*b)//GCD(a,b)
    # Modified merge for inversion
    def merge(a,start,mid,end,d):
        p=start
        q=mid+1
        arr=[0]*(end-start+1)
        k=0
        coun=0
        for i in range(start,end+1):
            if p > mid:
                arr[k]=a[q]
                q+=1
                k+=1
            elif q > end:
                arr[k]=a[p]
                d[a[p]] += coun
                k+=1
                p+=1
            elif a[p] < a[q]:
                arr[k]=a[p]
                d[a[p]]+=coun
                k+=1
                p+=1
            else:
                arr[k]=a[q]
                k+=1
                q+=1
                coun+=1

        for i in range(k):
            a[start]=arr[i]
            start+=1
    def mergesort(a, start, end,d):
        if start<end:
            mid=(start+end)//2
            mergesort(a,start,mid,d)
            mergesort(a,mid+1,end,d)
            merge(a,start,mid,end,d)
    # inversion return dic for every index inversion count
    def inversion(l):
        d={}
        for i in l:
            d[i]=0
        mergesort(l,0,len(l)-1,d)
        return d
    def binary_search_lower(A,low,high,k):
        if high-low!=1:
            mid=(low+high)//2
            x = A[mid]
            if x>=k:
                return binary_search_lower(A,low,mid,k)
            else:
                return binary_search_lower(A,mid,high,k)
        if A[low]>=k:
            return low
        else:
            return high
    # Function to find power
    def binary_expo(x,n):
        if n==0:
            return 1
        elif n%2==0:
            return binary_expo(x*x,n//2)
        else:
            return x*binary_expo(x*x,(n-1)//2)
    # Function to find power with given modulus
    def modu_expo(x,n,m):
        if n==0:
            return 1
        elif n%2==0:
            return modu_expo((x*x)%m,n//2,m)
        else:
            return (x*modu_expo((x*x)%m,(n-1)//2,m))%m
    # Function for modular multiplicative inverse via using extended_GCD_Euclid's
    def eEuclid(c, m):
        if m == 0:
            global d
            global x
            global y
            d = c
            x = 1
            y = 0
        else:
            eEuclid(m, c % m)
            temp = x
            x = y
            y = temp - (c // m) * y
    def mod_Inv(c, m):
        eEuclid(c, m)
        return (x % m + m) % m
    # Function for nCr%p using fermat (p is prime)
    def ncr(n, r, p):
        num = den = 1
        for i in range(r):
            num = (num * (n - i)) % p
            den = (den * (i + 1)) % p
        return (num * pow(den,
                          p - 2, p)) % p
    #*************************************************************
    for _ in range(int(sys.stdin.readline())):
        n=int(sys.stdin.readline())
        ans="YES"
        x,y=0,0
        for i in range(n):
            a,b = map(int,sys.stdin.readline().split())
            if a<b:
                ans="NO"
            elif a<x or b<y:
                ans="NO"
            elif a-x<b-y:
                ans="NO"
            x=a
            y=b
        print(ans)

if __name__ == "__main__":
    main()
