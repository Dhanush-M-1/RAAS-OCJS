a=input().split()
n=int(input())
print(' '.join(a))
for i in range(n):
    x,y=input().split()
    a[a.index(x)]=y
    print(' '.join(a))
