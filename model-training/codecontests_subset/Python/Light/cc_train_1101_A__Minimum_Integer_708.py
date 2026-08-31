t=int(input())
q=[]
for i in range(t):
    l,r,d=map(int,input().split())
    if d<l or d>r:
        q.append(str(d))
    else:
        q.append(str((r//d+1)*d))
print("\n".join(q))