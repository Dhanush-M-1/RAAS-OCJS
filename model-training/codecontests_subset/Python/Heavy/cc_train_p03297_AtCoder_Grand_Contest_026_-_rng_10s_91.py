def gcd(a,b):
    if b==0:
        return a
    return gcd(b,a%b)

t=int(input())
for sdghsoewrgoijof in range(t):
    s=input().split()
    a,b,c,d=int(s[0]),int(s[1]),int(s[2]),int(s[3])
    if a<b or d<b:
        print("No")
        continue
    if a==b:
        if d<b:
            print("No")
            continue
        elif d==b:
            print("Yes")
            continue
        else:
            a=d
    if a%b>c:
        print("No")
        continue
    if d%b==0:
        print("Yes")
    else:
        g=gcd(b,d)
        if b+(a%g)-g>c:
            print("No")
        else:
            print("Yes")