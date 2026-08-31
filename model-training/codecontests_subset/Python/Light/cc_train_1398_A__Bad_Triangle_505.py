for _ in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    for i in range(n-2):
        for j in range(i+1,n-1):
            for k in range(j+1,n):
                if a[i]+a[j]>a[k] and a[i]+a[k]>a[j] and a[j]+a[k]>a[i]:
                    c=1
                    continue
                else:
                    c=0
                    print("{} {} {}".format(i+1,j+1,k+1))
                    break
                break
            break
        break
    if c==1:
        print(-1)