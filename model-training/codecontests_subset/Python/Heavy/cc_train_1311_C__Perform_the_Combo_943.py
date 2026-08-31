for t in range (int(input())):
    n,m = map(int, input().split())
    s=input()
    p=list(map(int, input().split()))
    
    p.sort()
    a=[]
    c=m+1
    a.append(c)
    i=1
    k=0
    while i<n-1:
        
        if k<m and i==p[k]:
            c-=1
            k+=1
        else:
            a.append(c)
            i+=1
    b=[0 for j in range (26)]
##    for j in range (97, 123):
##        b[j]=0
    for i in range(n-1):
        b[ord(s[i])-97]+=a[i]
    b[ord(s[n-1])-97]+=1
    u=list(map(str, b))
    print(' '.join(u))