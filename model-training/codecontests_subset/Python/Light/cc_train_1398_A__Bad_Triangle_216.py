#Consistency is the key.
#code by: amrit00
from sys import stdin,stdout
import math
input=stdin.readline
def print(*args,end='\n'):
    s=[]
    for i in args:
        s.append(str(i)+' ')
    s=''.join(s)
    stdout.write(s+end)
    

def solve():
    n=int(input())
    l=list(map(int,input().split()))

    if l[0]+l[1]<=l[-1]:
        print(1,2,n)
    else:
        print(-1)
                        
tt=1
tt=int(input())
for __ in range(tt):
    solve()
