t=int(input())
for i in range(0,t):
    n=int(input())
    f=0
    a=list(map(int,input().split()))
    summ=a[0]+a[1]
    for j in range(2,len(a)):
        if summ<=a[j]:
            f=j
            break
    if f==0:
        print(-1)
    elif f!=0:
        print(1,end=' ')
        print(2,end=' ')
        print(f+1)