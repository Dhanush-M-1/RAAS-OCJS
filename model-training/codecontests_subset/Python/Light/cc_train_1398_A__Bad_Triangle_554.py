for _ in range(int(input())):
    n=int(input())
    data=[int(x) for x in input().split()]
    if((data[0]+data[1])<=data[n-1]):
        print(1,2,n)
    elif((data[n-1]-data[n-2])>=data[0]):
        print(1,n-1,n)
    else:
        print(-1)