for _ in range(int(input())):
    n = int(input())
    arr = []
    for row in range(n):
        arr.append(input())
    n = n+1
    if arr[0][1] == arr[1][0] == arr[-2][-1] == arr[-1][-2]:
        print(2)
        print(n-2, n-1)
        print(n-1, n-2)
        continue
    elif arr[0][1] == arr[1][0]:
        if arr[-2][-1] == arr[-1][-2]:
            print(0)
        else:
            print(1)
            if arr[-2][-1] == arr[0][1]:
                print(n-2, n-1)
            else:
                print(n-1, n-2)
    elif arr[-2][-1] == arr[-1][-2]:
        if arr[0][1] == arr[1][0]:
            print(0)
        else:
            print(1)
            if arr[0][1] == arr[-2][-1]:
                print(1, 2)
            else:
                print(2, 1)
    else:
        ref = arr[0][1]
        print(2)
        print(2, 1)
        if arr[-2][-1] == ref:
            print(n-2, n-1)
        elif arr[-1][-2] == ref:
            print(n-1, n-2)