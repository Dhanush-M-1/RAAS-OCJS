n,m=map(int,input().split())
x=[]
for i in range(n):
    q=list(map(int,input().split()))
    q.pop(0)
    x+=q
x=list(set(x))
print("YES" if len(x)==m else "NO")

