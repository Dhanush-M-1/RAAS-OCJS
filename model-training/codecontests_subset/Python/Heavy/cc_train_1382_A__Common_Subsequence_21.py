from sys import stdin,stdout
import math 
from collections import Counter,deque
L=lambda:list(map(int, stdin.readline().strip().split()))
M=lambda:map(int, stdin.readline().strip().split())
I=lambda:int(stdin.readline().strip())
IN=lambda:stdin.readline().strip()
C=lambda:stdin.readline().strip().split()
mod=1000000007
#Keymax = max(Tv, key=Tv.get)
def s(a):print("".join(list(map(str,a))))
#______________________-------------------------------_____________________#
#I_am_pavan
def solve():
    n,m=M()
    a=L();b=L()
    c=set(a).intersection(set(b))
    c=list(c)
    if c:
        print("YES")
        print(1,c[0])
    else:
        print("NO")
for _ in range(I()):
    solve()
