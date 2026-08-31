t=int(input())
for i in range(t):
    a,b=map(int,input().split())
    s=input()
    ans=[0]*26
    arr = [[0 for i in range(a)] for j in range(26)]
    l=list(map(int,input().split()))
    e=set()
    r=[]
    rt=[0]*26
    for j in range(a):
        d=ord(s[j])-97
        if d not in e:
            e.add(d)
            r.append(chr(d+97))
        rt[d]+=1
        arr[d][j]=rt[d]
        
    for i in range(26):
        for j in range(1,a):
            if arr[i][j]==0:
               arr[i][j]+=arr[i][j-1]
   
    for i in range(len(r)):
        j=ord(r[i])-97
        for k in range(b):
            ans[j]+=arr[j][l[k]-1]
        ans[j]+=arr[j][a-1]
    print(*ans,sep=" ")
            