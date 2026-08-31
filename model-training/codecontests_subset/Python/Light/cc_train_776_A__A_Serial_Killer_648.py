a,b=input().split()
print(a,b)
n=int(input())
for i in range(n):
    c,d=input().split()
    if c==a:
        print(d,b)
        a=d
    else:
        print(d,a)
        b=d