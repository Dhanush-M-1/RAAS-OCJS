a,b=map(str,input().split())
n=int(input())
print(a,b)
for i in range(n):
    c,d=map(str,input().split())
    if a==c :
        a=d
    else:
        b=d
    print(a,b)