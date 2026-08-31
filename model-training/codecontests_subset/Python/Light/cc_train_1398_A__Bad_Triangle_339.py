import bisect


def multiple_input(): return map(int, input().split())


def list_input(): return list(map(int, input().split()))


for _ in range(int(input())):
    n = int(input())
    a = list_input()
    s = a[0] + a[1]
    x = a[-1]
    if s > x:
        print(-1)
    else:
        print(1, 2, n)