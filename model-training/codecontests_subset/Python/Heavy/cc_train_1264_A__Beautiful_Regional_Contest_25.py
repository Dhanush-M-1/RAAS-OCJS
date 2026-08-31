from collections import Counter
for _ in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    d=Counter(l)
    l=sorted(l)[::-1]
    l1=l[0:len(l)//2]
    s=l[len(l)//2]
    a=len(l1)
    for i in range(len(l1)-1,-1,-1):
        if(l1[i]==s):
            a=i
    l1=l1[0:a]
    d=Counter(l1)
    if(len(d)<3):
        print(0,0,0)
    else:
        g1=max(l1)
        g=d[g1]
        s=0
        for i in range(len(l1)):
            if(l1[i]!=g1):
                s1=l1[i]
                s+=d[s1]
                g1=l1[i]
            if(g<s):
                break
        b=len(l1)-g-s
        if(g<b and g<s):
            print(g,s,b)
        else:
            print(0,0,0)
