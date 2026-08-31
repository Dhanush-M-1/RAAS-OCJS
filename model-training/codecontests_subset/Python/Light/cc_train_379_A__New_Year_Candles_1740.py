x=[int(i) for i in input().split()]
a,b=x[0],x[1]
s=a
while b<=a:
    s+=a//b
    a=a//b+a%b
print(s)
