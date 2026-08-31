m=int(input())
for i in range(m):
    n=int(input())
    a=list(map(int,input().split(' ')))
    for j in range(2,len(a)):
        if a[j]>=a[0]+a[1]:
            print(1 ,2 ,j+1)
            break
    else:
        print(-1)
