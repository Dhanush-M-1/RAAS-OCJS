def gcd(a,b):
    c=max(a,b)
    d=min(a,b)
    if d==0:
        return a
    else:
        return gcd(d,c%d)
ab=list(input().split())
a=int(ab[0])
b=int(ab[1])
s=gcd(a,b)
a=a//s
b=b//s
h=0
while a!=1:
        if a%2==0:
            h=h+1
            a=a//2
        elif a%3==0:
            h=h+1
            a=a//3
        elif a%5==0:
            h=h+1
            a=a//5
        else:
            break    
while b!=1:
    if b%2==0:
        h=h+1
        b=b//2
    elif b%3==0:
        h=h+1
        b=b//3
    elif b%5==0:
        h=h+1
        b=b//5
    else:
        break
if a!=b:
    print(-1)
else:
    print(h)
        