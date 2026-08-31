for _ in range(0,int(input())):
    a=int(input())
    b=list(map(int,input().split()))
    b.sort()
    if b[0]+b[1]>b[a-1] and b[1]-b[0]<b[a-1] and b[a-1]-b[1]<b[0] and b[a-1]-b[0]<b[1]:
        print("-1")
    else:
        print(1,2,a)