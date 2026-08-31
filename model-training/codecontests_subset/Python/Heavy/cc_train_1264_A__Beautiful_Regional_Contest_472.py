def make(l):
    from collections import defaultdict
    import math
    dic=defaultdict(int)
    n=len(l)
    for i in range(n):
        dic[l[i]]+=1
    a=list(set(l))
    a.sort()
    limit=math.ceil(n/2)
    count,i=0,0
    while count<limit:
        count+=dic[a[i]]
        i+=1
    i=i-1
    #print(dic,i,'left')
    #print(a,'a')
    left=i
    ans=[]
    gold=dic[a[-1]]
    silver=0
    i=len(a)-2
    while silver<=gold and i>left:
        silver+=dic[a[i]]
        i-=1
    bronze=0
    while bronze<=gold and i>left:
        bronze+=dic[a[i]]
        i-=1
    while bronze<(n//2-silver-gold) and i>left:
        bronze+=dic[a[i]]
        i-=1
    count=0
    ans=[gold,silver,bronze]
    for i in range(3):
        if ans[i]==0:
            count+=1
    if count>0:
        return [0,0,0]
    if silver<=gold:
        #print(gold,silver,bronze,'s<g')
        return [0,0,0]
    if bronze<=gold:
        return [0,0,0]
    return [gold,silver,bronze]
t=int(input())
import sys
for _ in range(t):
    n=int(sys.stdin.readline())
    l=list(map(int,sys.stdin.readline().split()))
    print(*make(l))
