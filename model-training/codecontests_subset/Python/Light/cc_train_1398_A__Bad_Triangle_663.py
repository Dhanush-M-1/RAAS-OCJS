for t in range(int(input())):
    n=int(input())
    num=list(map(int,input().split()))
    if num[-1]<num[0]+num[1]:
        print(-1)
    else:
        print(1,2,n)