n=int(input())
a=list(map(int,input().split()))

i=0
ans=0
while i<n:
    ans=max(min(a[i]-1,1000000-a[i]),ans)
    i+=1
print(ans)