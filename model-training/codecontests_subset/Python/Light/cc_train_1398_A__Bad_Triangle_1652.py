t=int(input())
for i in range(t):
    n=int(input())
    a=[int(j) for j in input().split(" ")]
    for k in range(2,n):
        if (a[0]+a[1])<=a[k]:
            print(1,2,k+1)
            break
    else:
        print(-1)