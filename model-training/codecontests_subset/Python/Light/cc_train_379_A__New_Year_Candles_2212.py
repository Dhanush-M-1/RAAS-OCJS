a,b=map(int,input().split())
res=a
rem=0
while(a//b >= 1):
    k=a//b
    res=res + a//b
    a=k + a%b
print(res)