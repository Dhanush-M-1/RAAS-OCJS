import sys
from operator import add
t=1
def inp(): return sys.stdin.readline().strip()
    
for _ in range(t):
    n, k=map(int, inp().split())
    bothbooks=[]
    abooks=[]
    bbooks=[]
    for i in range(n):
        t, a, b= map(int,inp().split())
        if( a==1 and b==1):
            bothbooks.append(t)
        elif(a==1 and b==0):
            abooks.append(t)
        elif(a==0 and b==1):
            bbooks.append(t)
    abooks.sort()
    bbooks.sort()
    #abbooks=list(map(add, abooks, bbooks))
    abbooks = [a + b for a, b in zip(abooks, bbooks)]
    abbooks = abbooks+bothbooks
    abbooks.sort()
    if(k>len(abbooks)):
        print(-1)
    else:
        print(sum(abbooks[0:k]))