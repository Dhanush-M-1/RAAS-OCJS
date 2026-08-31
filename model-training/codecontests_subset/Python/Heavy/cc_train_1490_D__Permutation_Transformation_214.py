def tree(res, m, d=0):
    if len(m) == 1:
        res[m[0][0]] = d
    elif len(m) > 1:
        max_m = m[0]
        max_i = 0
        for j in range(len(m)):
            if m[j][1] > max_m[1]:
                max_m = m[j]
                max_i = j
        res[max_m[0]] = d
        tree(res, m[:max_i], d + 1)
        tree(res, m[max_i + 1:], d + 1)


def find():
    n = int(input())
    mas = tuple(enumerate(map(int, input().split())))
    res = [0] * n
    tree(res, mas)
    return res


for i in range(int(input())):
    print(*find())