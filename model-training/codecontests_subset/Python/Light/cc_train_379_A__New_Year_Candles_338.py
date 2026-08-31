a,b=map(int,input().split())
t=a
while True:
    t+=a//b
    a=a%b+a//b
    if a<b:
        break
print(t)
