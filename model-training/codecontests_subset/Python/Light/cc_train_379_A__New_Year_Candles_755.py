s=[int(x) for x in input().split()]
a=s[0]
b=s[1]
t=0
for i in range(10000000):
    if a>=b:
        m=int(a/b)
        c=a-m*b
        t+=m*b
        a=m+c
    elif a>=0 and a<b:
        t+=a
        break
print(t)
