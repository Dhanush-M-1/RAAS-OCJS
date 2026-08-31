def ceil(a,b):
    if a%b:
        return a//b + 1
    else:
        return a//b
n=int(input())
for i in range(n):
    l,r,d=map(int,input().split())
    if l>d:
        print(d)
    else:
        print((r//d + 1)*d)