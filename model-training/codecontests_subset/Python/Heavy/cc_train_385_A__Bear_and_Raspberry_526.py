import sys
import math as m
def main():
    pass
def binary(n):
    #decimal to binary
    return (bin(n).replace("0b", ""))
def decimal(s):
    #binary to decimal
    return (int(s, 2))
def pow2(n):
    #power of a number base 2
    p = 0
    while n > 1:
        n //= 2
        p += 1
    return (p)
def isPrime(n):
    # if  number is prime in √n time
    if (n == 1):
        return (False)
    else:
        root = int(n ** 0.5)
        root += 1
        for i in range(2, root):
            if (n % i == 0):
                return (False)
        return (True)
def lts(l):
    #list to string ,no spaces
    s=''.join(map(str,l))
    return s
def stl(s):
    #for each character in string to list with no spaces -->
    l=list(s)
    #for space in string  -->
    #l=list(s.split(" "))
    return l
#1000000007
mod=int(1e9)+7
def sinp(): return sys.stdin.readline().strip()
def iinp(): return int(input())
def ninp(): return map(int, sys.stdin.readline().strip().split())
def linp(): return list(map(int, sys.stdin.readline().strip().split()))
def p(a): print(a)
def p2(a,b):print(a,b)
#for _ in range(iinp()):
n,c=ninp()
x=linp()
diff=-23423
for i in range(n-1):
    diff=max(diff,x[i]-x[i+1])
if(diff-c<=0):
    print(0)
else:
    print(diff-c)




