from sys import stdin


def inp():
    return stdin.buffer.readline().rstrip().decode('utf8')


def itg():
    return int(stdin.buffer.readline())


def mpint():
    return map(int, stdin.buffer.readline().split())


# ############################## import
# ############################## main
# def solve():
for case in range(1, itg()+1):
    n = itg()
    arr = tuple(mpint())
    if arr[0] + arr[1] <= arr[-1]:
        print(1, 2, n)
    else:
        print(-1)
# Please check!
