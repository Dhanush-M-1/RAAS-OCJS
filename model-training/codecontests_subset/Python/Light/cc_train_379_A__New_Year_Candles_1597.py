a,b=map(int,input().split())
ans=a
c=a
while(c>=b):
    ans+=(c//b)
    c = c//b + c%b
print(ans)