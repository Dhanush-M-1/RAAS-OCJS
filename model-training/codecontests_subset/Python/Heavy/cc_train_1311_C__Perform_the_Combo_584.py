from collections import deque as dd
for _ in range(int(input())):
    n,m=map(int,input().split())
    s=input()
    p=list(map(int,input().split()))
    p.sort()
    d=dd()
    pre=0
    for i in range(m):
        if(p[i]!=pre):
            #d[(pre,p[i])]=len(p[i:])+1
            d.append((pre,p[i],m-i+1))
            pre=p[i]
    d.append((pre,n,1))
    #print(d)

    ans=[0]*26
    #print(d)
    for i in range(len(d)):
        x,y,v=d.pop()
        
        for j in s[x:y]:
            ans[ord(j)-97]+=v
            
    print(" ".join(str(z) for z in ans))
            
        
        
        
