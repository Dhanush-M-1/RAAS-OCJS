import math
from collections import Counter,deque
L=lambda:list(map(int,input().split()))
M=lambda:map(int,input().split())
I=lambda:int(input())
IN=lambda:input()
mod=10**9+7
def s(a):
    print(" ".join(list(map(str,a))))
#______________________-------------------------------_____________________#
def solve():
    n=I()
    a=n
    x=0;y=0
    while a%2==0:
        a=a//2
        x+=1
    while a%3==0:
        a=a//3
        y+=1
    if a!=1 or x>y:
        print(-1)
    else:
        print(2*(y-x)+x)
for i in range(I()):
    solve()
