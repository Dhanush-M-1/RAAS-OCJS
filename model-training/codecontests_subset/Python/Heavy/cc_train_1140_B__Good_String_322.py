import sys
import math
from collections import defaultdict,deque

input = sys.stdin.readline
def inar():
    return [int(el) for el in input().split()]
def main():
    t=int(input())
    for _ in range(t):
        n=int(input())
        st=input().strip()
        ans1=10**18
        for i in range(n-1,-1,-1):
            if st[i]=="<":
                ans1=n-i-1
                break
        ans2=10**18
        for i in range(n):
            if st[i]==">":
                ans2=i
                break
        print(min(ans1,ans2))




if __name__ == '__main__':
    main()



