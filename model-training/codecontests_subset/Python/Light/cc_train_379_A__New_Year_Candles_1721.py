a,b=input().split()
a=int(a)
b=int(b)
s=a
r1=0
for i in range(a):
    d=a/b
    d=int(d)
    s=s+d
    r=a%b
    r1=r1+r
    if r1>=b:
        d=d+r1
        r1=0
    if d>b or d==b:
        a=d

    if d<b:
        if (d+r1>=b):
            s=s+1
        break
s=int(s)
print(s)