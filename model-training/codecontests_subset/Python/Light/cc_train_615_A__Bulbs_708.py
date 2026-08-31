n,m=map(int, input().split())
x=""
for i in range(n):
    y=input().split()
    for i in range(len(y)-1):
        x=x+" "+y[i+1]
z=set(x.split())
if len(z)==m:
    print("YES")
else:
    print("NO")
