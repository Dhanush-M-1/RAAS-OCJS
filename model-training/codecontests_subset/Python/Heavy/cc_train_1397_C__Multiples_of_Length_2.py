from sys import stdin


def inp():
    return stdin.buffer.readline().rstrip().decode('utf8')


def itg():
    return int(stdin.buffer.readline())


def mpint():
    return map(int, stdin.buffer.readline().split())


# ############################## import
# ############################## main
# for __ in range(itg()):
n = itg()
if n == 1:
    print("1 1")
    print(-itg())
    print("1 1")
    print("0")
    print("1 1")
    print("0")
    exit()
arr = list(mpint())
print(1, n - 1)
print(*map(lambda x: x*(n-1), arr[:-1]))
print(2, n)
print(*[0] * (n - 2) + [arr[-1] * (n-1)])
print(1, n)
print(*map(lambda x: -x*n, arr))
# Please check!
