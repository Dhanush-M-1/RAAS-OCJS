n=int(input())
for i in range(n):
    m=int(input())
    a=[int(i) for i in input().split()]
    a=sorted(a)
    if((a[0]+a[1])>a[len(a)-1] and (a[len(a)-1]-a[1])<a[0]):
        print(-1)
    else:
        print(1,2,len(a))