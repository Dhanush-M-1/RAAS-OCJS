n = int(input())


def f(s, max_i):
    if len(s) >= n:
        print(s)
    else:
        for i in range(max_i+2):
            f(s + chr(ord('a') + i), max(max_i, i))


f('a', 0)
