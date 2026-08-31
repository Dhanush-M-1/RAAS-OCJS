for xyz in range(0,int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    if((l[0]+l[1])<=l[-1]):
        print(1,2,n)
    else:
        print(-1)