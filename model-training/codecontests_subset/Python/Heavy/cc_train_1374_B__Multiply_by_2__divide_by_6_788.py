for _ in range(int(input())):
    n=int(input())
    # n,k=map(int,input().split())
    # a=list(map(int,input().split()))
    if n==3: print(2); continue
    if n==1: print(0); continue
    if n<6: print(-1); continue
    if n==6: print(1); continue
    dic={2:0,3:0}
    while n%8==0:
        dic[2]+=3
        n//=8
    while n%2==0:
        dic[2]+=1
        n//=2
    while n%27==0:
        dic[3]+=3
        n//=27
    while n%3==0:
        dic[3]+=1
        n//=3
    if n>1 or dic[2]>dic[3]: print(-1); continue
    print(2*dic[3]-dic[2])