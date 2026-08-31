n = int(input())
x = list(map(int, input().split()))
i = 0
if max(x) >= 10 ** 6 // 2:
    try:
        while x[i] <= 10 ** 6 // 2:
            i += 1
        if i != 0:
            if x[i - 1] - 1 > 10 ** 6 - x[i]:
                a = x[i - 1] - 1
            else:
                a = 10 ** 6 - x[i]
        else:
            a = 10 ** 6 - x[i]
    except IndexError:
        a = 499999
else:
    a = x[-1] - 1
print(a)
