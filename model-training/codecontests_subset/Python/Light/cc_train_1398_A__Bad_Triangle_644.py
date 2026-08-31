for _ in range(int(input())):
    n = int(input())
    arr = list(map(int,input().split()))
    notexist = False
    for i in range(2,len(arr)):
        if arr[0] + arr[1] <= arr[i]:
            n = i + 1
            notexist = True
            break
    if notexist:
        print(1,2,n)
    else:
        print(-1)
    
    