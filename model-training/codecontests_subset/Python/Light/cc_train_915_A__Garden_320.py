a=list(map(int,input().split()))
c=list(map(int,input().split()))
f=[]
for i in range(a[0]):
    if a[1]%c[i]==0 and c[i]<=a[1] or c[i]==1:
        f.append(c[i])
    else:
        continue
f.sort()
f.reverse()
print(int(a[1]/f[0]) if f!=[] else a[1])