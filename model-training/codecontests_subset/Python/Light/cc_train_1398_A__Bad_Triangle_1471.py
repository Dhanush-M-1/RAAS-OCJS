for _ in [0]*int(input()):
    n = int(input())
    arr=[int(a) for a in input().split()]
    if (arr[0]+arr[1] <= arr[-1]):
        print(1,2,n)
    else:
        print(-1)
        
