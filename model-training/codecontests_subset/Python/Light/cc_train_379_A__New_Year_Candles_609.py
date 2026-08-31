a,b=[int(i)for i in input().split()]
s=a
while(1):
    c=a//b
    a=c+(a%b)
    s+=c
    if(a<b):
        break
print(s)