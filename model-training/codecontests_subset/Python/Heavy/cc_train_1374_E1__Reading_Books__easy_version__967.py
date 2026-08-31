import sys
import math as mt
input=sys.stdin.buffer.readline  
t=1
def Sort(sub_li): 
   
    sub_li.sort(key = lambda x: x[0]) 
    return sub_li 
#t=int(input())
for _ in range(t):
    #n=int(input())
    n,k=map(int,input().split())
    #l=list(map(int,input().split()))
    l2=[]
    common=[]
    alice=[]
    bob=[]
    for ___ in range(n):
        
        time,a,b=map(int,input().split())
        if (a&b):
            common.append(time)
        else:
            if (a):
                alice.append(time)
            if (b):
                bob.append(time)
    
    common.sort()
    alice.sort()
    bob.sort()
    
    if (len(common)+min(len(alice),len(bob)))<k:
        print(-1)
    else:
        common.append(10**9)
        alice.append(10**9)
        bob.append(10**9)
        al,bo=0,0
        co=0
        i=0
        ans=0
        while i<k :
            if (common[co]<=(bob[bo]+alice[al])) :
                ans+=common[co]
                i+=1
                co+=1
            else:
                ans+=(bob[bo]+alice[al])
                i+=1
                al+=1
                bo+=1
        print(ans)        