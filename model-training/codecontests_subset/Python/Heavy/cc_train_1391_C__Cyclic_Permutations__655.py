import sys
input = sys.stdin.readline
import math
############ ---- Input Functions ---- ############
def inp():
    return(int(input()))
def inlt():
    return(list(map(int,input().split())))
def insr():
    s = input()
    return(list(s[:len(s) - 1]))
def invr():
    return(map(int,input().split()))

def fact(n,mod = 1e9+7):
    i = 1
    res = 1
    while i<=n:
        res = (res*i)%mod
        i+=1
    return res

if __name__ == '__main__':
    n = inp()
    f = fact(n)
    p = (int)(1e9 + 7)

    # Using direct fast method to compute
    # (a ^ b) % p.


    l = pow(2, n-1, p)
    f -= l
    if f<0:
        f+= p
    print(int(f))