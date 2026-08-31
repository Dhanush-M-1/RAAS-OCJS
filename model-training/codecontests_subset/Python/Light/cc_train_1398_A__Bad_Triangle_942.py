for test in range(0,int(input())):
    n=int(input())
    arr=[int(x) for x in input().split()]
    one=arr[0]
    two=arr[1]
    third=arr[n-1]
    if one+two>third:
        print(-1)
    else:
        print(1,2,n)