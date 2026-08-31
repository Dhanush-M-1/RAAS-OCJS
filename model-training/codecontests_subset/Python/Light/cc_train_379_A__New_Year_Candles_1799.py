total=0
a,b=map(int,input().split())
total=a
while 1:
    c=a//b
    a=c+(a%b)
    total+=c
    if a<b:
        break
print(total)