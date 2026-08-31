import sys

input = sys.stdin.readline
sys.setrecursionlimit(10 ** 6)


############ ---- Input Functions ---- ############
def in_int():
    return (int(input()))


def in_list():
    return (list(map(int, input().split())))


def in_str():
    s = input()
    return (list(s[:len(s) - 1]))


def in_ints():
    return (map(int, input().split()))


t = in_int()

while t > 0:
    t -= 1

    n = in_int()

    a = []

    for xx in range(n):
        l = in_list()
        a.append(l)

    player = a[0][0]
    clear = a[0][1]

    if player < clear:
        print('NO')
    else:
        ans = True
        for ll in a[1:]:
            p = ll[0]
            c = ll[1]
            if p >= player and c >= clear and p >= c and p - player >= c- clear:
                player = p
                clear = c
                continue
            ans = False
        if ans:
            print('YES')
        else:
            print('NO')