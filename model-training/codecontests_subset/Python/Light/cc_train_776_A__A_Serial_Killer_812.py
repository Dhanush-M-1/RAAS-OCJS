a,b=map(str,input().split())
print(a,b)
n=int(input())
for i in range(n):
    x,y=map(str,input().split())
    if x==a: a=y
    elif x==b: b=y
    elif y==a: a=x
    else: b=y
    print(a,b)