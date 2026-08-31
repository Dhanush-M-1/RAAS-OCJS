for i1 in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    
    t1=a[0]
    t2=a[1]
    t3=a[-1]
    
    if t3>=(t1+t2):
        print(1,2,n)
        continue
    else:
        print(-1)
            