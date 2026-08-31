q = int(input())
for i in range(q):
    a=list(map(int,input().split()))
    if(a[2]>a[1] or a[2]<a[0]):
        print(a[2])
    else:
        s=a[1]//a[2]
        print((s+1)*a[2])
