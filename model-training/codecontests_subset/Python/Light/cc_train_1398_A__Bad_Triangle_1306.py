for i in range (int(input())):
    n=int(input())
    l1=list(map(int,input().split()))
    if(l1[0]+l1[1]<=l1[n-1]):
        print("1 2 ",n)
    else:
        print(-1)
