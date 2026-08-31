def solve(number, len):
    x = len - number
    #print('--------------', number, x, number + x * (len - 1))
    if (number + x * (len - 1)) % len == 0:
        return x
    else:
        x = len + number
        return x


LEN = int(input())
arr = list(map(int, input().split()))
if LEN != 1:
    y = arr[-1]
    arr = arr[:-1]

    m = LEN - 1

    print(1, m)
    new_arr = []
    for i in arr:
        x = solve(i, LEN)
        new_arr.append(x * (LEN - 1) + i)
        print(x * (LEN - 1), end=' ')
    print()
    print(LEN, LEN)
    print(-(y % LEN))
    y = y - y % LEN
    print(1, LEN)
    for i in new_arr:
        print(-i, end=' ')
    print(-y)
else:
    print(1, 1)
    print(-arr[0])
    print(1, 1)
    print(0)
    print(1, 1)
    print(0)


