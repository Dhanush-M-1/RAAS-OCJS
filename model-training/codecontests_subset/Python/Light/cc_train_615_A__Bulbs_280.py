n,m=map(int,input().split())
a=[]
s=set()
for i in range(n):
    a.append([x for x in input().split()])
    del(a[i][0])
    s=s|set(a[i])
print("YES" if len(s)==m else "NO")
