a,b = map(int,input().split())
ans = a
while a>=1:
    a = a/b
    ans+=a
print(int(ans))