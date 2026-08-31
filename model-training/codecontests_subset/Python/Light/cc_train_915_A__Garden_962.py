read=lambda:map(int,input().split())
n,k=read()
ans=min(k//a for a in list(read()) if k%a==0)
print(ans)