import sys

input = lambda: sys.stdin.readline().rstrip()


def dp_(mi):
    dp = [0]
    for i in range(len(mi) - 1):
        dp.append(abs(mi[i] - mi[i + 1]))

    return dp
   


for _ in range(int(input())):
    l = int(input())
    mas = list(map(int, input().split()))
    c = []
    an = []
    for i in range(l):
        if mas[i] == -1:
            an.append(i)
            if i == 0:
                if mas[i + 1] != -1:
                    c.append(mas[i + 1])
            elif i == l - 1:
                if mas[i - 1] != -1:
                    c.append(mas[i - 1])
            else:
                if mas[i - 1] != -1:
                    c.append(mas[i - 1])
                if mas[i + 1] != -1:
                    c.append(mas[i + 1])
    g = 0
    if len(c) != 0:
        ans = (max(c) + min(c)) // 2
        for i in an:
            mas[i] = ans
        print(max(dp_(mas)), ans)
    else:
        print(0, 1)
