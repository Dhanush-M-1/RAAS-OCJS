n = int(input())
a = "abcdefghijklmmopkrstuvwxyz"


def solve(s, m):
    if len(s) == n:
        print(s)
        return
    for v in a:
        if ord(v)-m <= 1:
            solve(s+v, max(m, ord(v)))


solve("a", ord("a"))
