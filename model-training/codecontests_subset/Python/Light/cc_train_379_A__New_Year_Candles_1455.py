a,b=input().split()
t=0
a=int(a)
b=int(b)
c=0
while a>0:
    c+=a
    t+=a
    a=c//b
    c=c%b
print(t)
