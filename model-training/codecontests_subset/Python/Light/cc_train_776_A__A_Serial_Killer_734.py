a,b=map(str,input().split())
print(a,b)
n=int(input())
for i in range(n):
    c,d=map(str,input().split())
    if c==a:
        a=d
    elif c==b:
        b=d
    print(a,b)
