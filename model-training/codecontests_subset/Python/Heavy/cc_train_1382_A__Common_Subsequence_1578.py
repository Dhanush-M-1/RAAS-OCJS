def hello():
    from collections import Counter
    a, b = map(int, input().split(' '))
    arr1 = list(map(int, input().split(' ')))
    arr2 = list(map(int, input().split(' ')))
    arr1.sort()
    f = set(arr1)
    g = set(arr2)
    arr2.sort()
    flag = False
    ans = []
    first = Counter(f)
    second = Counter(g)
    for i in first:
        if i in second:
            # print('YES')
            ans.append(first[i])
            ans.append(i)
            return ans
        else:
            continue

    return ans


for _ in range(int(input())):
    s = hello()
    if len(s) != 0:
        print('YES')
        print(*s)
    else:
        print('NO')