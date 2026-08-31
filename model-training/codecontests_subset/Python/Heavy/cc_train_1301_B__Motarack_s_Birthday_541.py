def one():
    return int(input())


def two():
    return map(int, input().split())


def lis():
    return list(map(int, input().split()))


def st():
    return input()


for _ in range(one()):
    input()
    l = lis()
    m = 10 ** 9
    M = 0

    for ind, i in enumerate(l):
        if i == -1:
            if ind == 0:
                if l[ind + 1] == -1:
                    continue
                if m > l[ind + 1]:
                    m = l[ind + 1]
                if M < l[ind + 1]:
                    M = l[ind + 1]
            elif ind == len(l) - 1:
                if l[ind - 1] == -1:
                    continue
                if m > l[ind - 1]:
                    m = l[ind - 1]
                if M < l[ind - 1]:
                    M = l[ind - 1]
            else:
                if l[ind - 1] != -1:
                    if m > l[ind - 1]:
                        m = l[ind - 1]
                    if M < l[ind - 1]:
                        M = l[ind - 1]
                if l[ind + 1] != -1:
                    if m > l[ind + 1]:
                        m = l[ind + 1]
                    if M < l[ind + 1]:
                        M = l[ind + 1]
    k = (M + m) // 2
    if k == -1:
        k = 1
    maxabs = 0
    for i in range(len(l) - 1):
        if l[i] == -1:
            l[i] = k
        if l[i + 1] == -1:
            l[i + 1] = k
        if maxabs < abs(l[i] - l[i + 1]):
            maxabs = abs(l[i] - l[i + 1])

    print(maxabs, k)
