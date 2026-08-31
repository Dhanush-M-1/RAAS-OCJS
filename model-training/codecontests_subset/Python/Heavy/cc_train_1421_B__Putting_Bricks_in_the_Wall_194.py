t = int(input())
for q in range(t):
    a = int(input())
    arr = []
    for w in range(a):
        arr.append(list(input()))
    x1 = int(arr[0][1])
    x2 = int(arr[1][0])
    x3 = int(arr[a - 2][a - 1])
    x4 = int(arr[a - 1][a - 2])
    if x1 == x2:
        if x3 == x4:
            if x1 == x3:
                print(2)
                print(1, 2)
                print(2, 1)
            else:
                print(0)
        else:
            if x3 == x1:
                print(1)
                print(a - 1, a)
            else:
                print(1)
                print(a, a - 1)
    else:
        if x1 == x3:
            if x3 == x4:
                print(1)
                print(1, 2)
            else:
                print(2)
                print(2, 1)
                print(a - 1, a)
        else:
            if x3 == x4:
                print(1)
                print(2, 1)
            else:
                print(2)
                print(2, 1)
                print(a, a - 1)