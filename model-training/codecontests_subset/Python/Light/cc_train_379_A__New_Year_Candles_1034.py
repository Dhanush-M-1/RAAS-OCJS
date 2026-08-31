a,b=map(int,input().split())
res=a
ost=0
while True:
    res+=a//b
    a=a//b+a%b
    if a<b:
        break
print(res)