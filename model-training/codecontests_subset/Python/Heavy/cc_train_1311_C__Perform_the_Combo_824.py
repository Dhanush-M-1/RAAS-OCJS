t=int(input())
for i in range(t):
    n,m=map(int,input().split())
    nlist=list(input())
    mlist=list(map(int,input().split()))
    ans=[]
    for j in range(n):
        ans.append([0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0])
    ans[0][ord(nlist[0])-97]+=1
    for j in range(1,n):
        for k in range(26):
            if(k==ord(nlist[j])-97):
                ans[j][k]=ans[j-1][k]+1
            else:
                ans[j][k]=ans[j-1][k]
    finalans=[0]*26
    for j in mlist:
        for k in range(26):
            finalans[k]+=ans[j-1][k]
    for k in range(26):
            finalans[k]+=ans[n-1][k]
    for j in finalans:
        print(j,end=" ")
    print()
        
    