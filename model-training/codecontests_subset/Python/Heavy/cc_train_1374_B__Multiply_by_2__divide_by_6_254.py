def list_input(): return list(map(int, input().split()))


def multiple_input(): return map(int, input().split())


def factor(x):
    count2, count3 = 0, 0
    temp = x
    while x % 2 == 0:
        x /= 2
        count2 += 1
    while x % 3 == 0:
        x /= 3
        count3 += 1
    if (2 ** count2) * (3 ** count3) != temp:
        return -1
    else:
        if count2 < count3:
            return count3 - count2 + count3
        elif count2 == count3:
            return count3
        else:
            return -1


for _ in range(int(input())):
    n = int(input())
    if n == 1:
        print(0)
    else:
        print(factor(n))