a=[s for s in input().split()]
n=int(input())
for i in range(n):
    print(' '.join(j for j in a))
    x, y = [s for s in input().split()]
    if a[0]==x:
        a[0]=y
    else:
        a[1]=y
print(' '.join(j for j in a))