#Consistency is the key.
#code by: amrit2000
from sys import stdin,stdout
import math
input=stdin.readline
def print(x='',y='',end='\n'):
    if y=='':
        stdout.write(str(x)+end)
    else:
        stdout.write(str(x)+' '+str(y)+end)

def solve():
    n,m=map(int,input().split())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))

    s1=set(a)
    s2=set(b)

    t=s1.intersection(s2)

    if t:
        print('YES')
        t=list(t)
        print(1,t[0])
    else:
        print('NO')
    

                
            
tt=1
tt=int(input())
for __ in range(tt):
    solve()
