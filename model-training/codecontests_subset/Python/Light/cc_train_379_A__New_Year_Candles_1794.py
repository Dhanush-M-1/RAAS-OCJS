a,b=input().split()
a=int(a)
b=int(b)
rs=a
while a>=b:
    rs=rs+(a//b)
    a=(a//b)+(a%b)
print(rs)
