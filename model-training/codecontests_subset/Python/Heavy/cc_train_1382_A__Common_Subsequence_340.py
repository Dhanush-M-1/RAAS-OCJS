t = int(input())

for i in range(t):
    n1, n2 = map(int, input().split())

    arr1 = list(map(int, input().split()))
    arr2 = list(map(int, input().split()))

    found = False
    if n1 >= n2:
        for i in arr1:
            if i in arr2:
                print('YES')
                print(1, i)
                found = True
                break
    else:
        for i in arr2:
            if i in arr1:
                print('YES')
                print(1, i)
                found = True
                break

    if not found:
        print('NO')
