from collections import defaultdict,Counter

#list(map(int,input().split())
#map(int,input().split()
def solve():
    n=int(input())
    p=-1
    q=-1
    test=0
    ls=[]
    for i in range(n):
        x,y=map(int,input().split())
        ls.append([x,y])
    for [x,y] in ls:
        if p>x:
            test=1
            break
        elif q>y:
            test=1
            break
        elif y>q and x==p:
            test=1
            break
        
        elif (y-q)>(x-p):
            test=1
            break
        
        else:
            
            p=x
            q=y
    if test:
        print("No")
    else:
        print("YES")
            

for _ in range(int(input())):
    solve()