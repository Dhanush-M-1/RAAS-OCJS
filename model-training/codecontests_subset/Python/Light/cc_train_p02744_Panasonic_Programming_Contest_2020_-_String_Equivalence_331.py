N = int(input())
s = 'abcdefghijklmn'


def f(d, now, kind):
    if d == N:
        print(now)
        return
    for i in range(kind):
        f(d + 1, now + s[i], kind)
    f(d + 1, now + s[kind], kind + 1)

f(0, '', 0)
