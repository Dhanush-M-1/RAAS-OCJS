t=int(input())
from collections import defaultdict
for _ in range(t):
    n,m=list(map(int,input().split()))
    dict={}
    for i in range(26):
        dict[chr(i+97)]=0
    
    s=input()
    for x in s:
        dict[x]+=1
    p=list(map(int,input().split()))
    p.sort()
    val=len(p)
    dt=defaultdict(int)
    for x in p:
        dt[x]+=1
    #print(dt)
    for i in range(n):
        #print(dict['c'],1)
        if dt[i+1]!=0:
            dict[s[i]]+=val
            val-=dt[i+1]
        else:
            dict[s[i]]+=val
        #print(dict['c'],2)
    #print(dict)
    print(*list(dict.values()))




    