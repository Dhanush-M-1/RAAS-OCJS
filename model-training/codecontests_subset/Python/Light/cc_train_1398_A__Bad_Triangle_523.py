for _ in range(int(input())):
    n= int(input())
    li= list(map(int, input().strip().split()))
    if(li[0]+li[1]>li[-1]):
        print(-1)
    else:
        print(1,2,n)

