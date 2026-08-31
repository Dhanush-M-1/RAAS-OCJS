a,b=input().split()
a=int(a)
b=int(b)
d=a//b
c=a+d
e=1
while d>=1:
    a= a//b+ a%b
    d=a//b
    c=c+d
print(c)