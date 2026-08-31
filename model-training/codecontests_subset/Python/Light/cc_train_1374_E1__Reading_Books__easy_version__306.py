n,k=map(int,input().split());abt=[];at=[];bt=[]
for i in range(n):
    t,a,b=map(int,input().split())
    if a&b:abt.append(t)
    elif a:at.append(t)
    elif b:bt.append(t)
at.sort();bt.sort()
for i in range(min(len(at),len(bt))):abt.append((at[i]+bt[i]))
if len(abt)<k:print(-1)
else:print(sum(sorted(abt)[:k]))