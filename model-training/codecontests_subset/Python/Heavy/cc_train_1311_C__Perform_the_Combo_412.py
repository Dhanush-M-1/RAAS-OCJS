for _ in range(int(input())):
    n,m=map(int,input().split())
    s= input()
    a=[0 for i in range(26)]
    p= list(map(int,input().split()))
    d=[0 for i in range(n)]
    
    for i in range(n):
        a[ord(s[i])-97]+=1
        
    for i in range(m):
        d[p[i]-1]+=1
    c=0
   # print(d)
    for i in range(n-1,-1,-1):
        if c==0 and d[i]==0:
            d[i]=0
        elif c==0 and d[i]!=0:
            c=d[i]
        elif c!=0 and d[i]==0:
            d[i]=c
        else:
            d[i]= d[i]+c
            c=d[i]
   # print(d)

    for i in range(n):
        a[ord(s[i])-97]+= d[i]
    
    print(" ".join(map(str,a)))
                    
