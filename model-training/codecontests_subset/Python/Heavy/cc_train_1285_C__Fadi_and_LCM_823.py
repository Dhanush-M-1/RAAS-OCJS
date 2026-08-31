import sys
import math
from collections import defaultdict,deque

input = sys.stdin.readline
def inar():
    return [int(el) for el in input().split()]
def main():
    x=int(input())
    ans=10**12
    pair=[0,0]
    for i in range(1,int(x**0.5)+1):
        if x % i==0:
            l=i*(x//i)/math.gcd(i,x//i)
            if l==x:
                if ans>max(i,x//i):
                    ans=max(i,x//i)
                    pair[0]=i
                    pair[1]=x//i
    print(*pair)


if __name__ == '__main__':
    main()



