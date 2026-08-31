l=[str(i) for i in input().split()]
n=int(input())
print(*l)
for i in range(n):
    a=[str(i) for i in input().split()]
    if(a[0]==l[0]):
        l[0]=a[1]
    else:
        l[1]=a[1]
    print(*l)