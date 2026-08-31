for i in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    if (l[0]+l[1]<=l[len(l)-1]):
        print(1,2,len(l))
    else:
        print(-1)