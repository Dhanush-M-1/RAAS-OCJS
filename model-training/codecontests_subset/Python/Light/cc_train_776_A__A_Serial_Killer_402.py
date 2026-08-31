a,b=map(str,input().split())
n=int(input())
for i in range(n+1):
    print(a,b)
    if i==n:
        break
    c,d=map(str,input().split())
    if c==a:
        a=d
    else:
        b=d

        