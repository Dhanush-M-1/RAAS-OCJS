n,k=map(int,input().split())
a=list(map(int,input().split()))
a.sort()
ls=[]
count=0
for i in range(n):
    if(i==0):
        count+=1
        if(i==n-1):
            ls.append([a[i],count])
    elif(a[i]==a[i-1]):
        count+=1
        if(i==n-1):
            ls.append([a[i],count])
    else:
        ls.append([a[i-1],count])
        count=1
        if(i==n-1):
            ls.append([a[i],count])
ans=0
i=0
while i<len(ls)-1:
    if(ls[i+1][0]>ls[i][0]+k):
        ans+=ls[i][1]
    i+=1
print(ans+ls[-1][1])    