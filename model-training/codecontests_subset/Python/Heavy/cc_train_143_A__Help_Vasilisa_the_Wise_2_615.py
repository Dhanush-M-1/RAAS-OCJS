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
def s(a):print(" ".join(list(map(str,a))))
#______________________-------------------------------_____________________#
#I_am_pavan

def solve():
    r1,r2=M();d1,d2=M();c1,c2=M()
    a=(c1+d1-r2)//2;b=c1-a;c=r1-a;d=r2-b
    if a!=b and a!=c and a!=d and b!=c and b!=d and c!=d and 1<=a<=9 and 1<=b<=9 and 1<=c<=9 and 1<=d<=9:
        print(a,c);print(d,b)
    else:print(-1)
for i in range(1):
    solve()
        
        


