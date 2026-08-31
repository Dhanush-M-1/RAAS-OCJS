def solve(a,n):
    for i in range(1,n+1):
        if i in a:
            continue
        else:
            return "NO"
    return "YES"


button,bulb=map(int,input().split())
a=[]
for i in range(button):
    x=[]
    x=list(map(int,input().strip().split()))
    x.pop(0)
    a=a+x

print(solve(a,bulb))