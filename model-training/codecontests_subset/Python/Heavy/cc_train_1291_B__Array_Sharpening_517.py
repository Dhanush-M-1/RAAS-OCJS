for t in range(int(input())):
    nums = int(input())
    arr=[int(x) for x in input().split(' ')]
    flag=False
    for i in range(len(arr)):
        if i<=arr[i] and i<len(arr)/2 or len(arr)-1-i<=arr[i] and i>=len(arr)/2:
            continue
        else:
            print('No')
            flag=True
            break
    if not flag:
        if len(arr)%2==0:
            fff=int(len(arr)/2)
            if arr[fff] == arr[fff-1] and fff-1 == arr[fff]:
                print('No')
            else:
                print('Yes')
        else:
            print('Yes')
