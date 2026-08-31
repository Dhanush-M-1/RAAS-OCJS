for i in range(int(input())):
    n = int(input())
    arr = list(map(int,input().split()))
    for i in range(len(arr)-1,1,-1):
        if arr[0] + arr[1] <= arr[i]:
            print(1,2,arr.index(arr[i])+1)
            break
    else:
        print(-1)
    