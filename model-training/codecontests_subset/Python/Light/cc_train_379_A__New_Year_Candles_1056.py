l=input().split()
a=int(l[0])
b=int(l[1])
t=0
s=a
while (a+t)/b>=1:
    s+=int(a/b)
    a=int(a/b+a%b)
print(s)