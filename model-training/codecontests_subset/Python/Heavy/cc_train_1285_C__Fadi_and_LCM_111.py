x = int(input())
tempx = x
if x == 1:
    print(1, 1)
else:
    arr = []
    i = 2
    cnt = 0
    new_arr = []
    while i * i <= x:
        if x % i == 0:
            arr.append(i)
            x /= i
        else:
            i += 1
    if x != 1:
        arr.append(int(x))
    arr.sort()
    arr.append(-1)
    for i in range(len(arr) - 1):
        if arr[i] == arr[i + 1]:
            cnt += 1
        else:
            new_arr.append(arr[i] ** (cnt + 1))
            cnt = 0
    num = set()
    num.add(new_arr[0])
    for i in range(1, len(new_arr)):
        temp = set()
        for j in num:
            temp.add(new_arr[i] * j)
        num |= temp
        num.add(new_arr[i])
    a = 10 ** 12
    b = 10 ** 12
    x = tempx
    for i in num:
        ans1 = int(i)
        ans2 = int(x // ans1)
        if max(ans1, ans2) < max(a, b):
            a = min(ans1, ans2)
            b = max(ans1, ans2)
    print(a, b)
