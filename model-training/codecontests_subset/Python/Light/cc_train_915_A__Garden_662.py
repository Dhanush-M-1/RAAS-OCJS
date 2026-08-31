n,k=(input().split())
a=list(map(int,input().split()))
a.sort()
ans=0
for i in a:
    if int(k)%int(i)==0:
        ans=i
print(int(k)//int(ans))
