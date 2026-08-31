T = int(input())
l = []
for k in range(T):
    N = int(input())
    a = list(map(int, input().split()))
    f=0
    for j in range(1,N-1):
        if a[0]+a[j]<=a[N-1]:
            l.append([1,j+1,N])
            f=1
            break
    if f==0: l.append([-1])

for k in range(T):
    if l[k][0]==-1:
        print (-1)
    else: print (l[k][0],l[k][1],l[k][2])

