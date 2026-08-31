from collections import Counter


def can(c, s):
    cc = Counter(s)
    return (c & cc) == cc


def how(c, c1):
    m = None
    for k in c1.keys():
        q = 0
        if k in c:
            q = c[k] // c1[k]
        if q == 0:
            return 0
        if m is None or m > q:
            m = q

    return m


def diff(c, f, c1):
    r = c.copy()
    for k in c1:
        r[k] -= f * c1[k]
    return r


def count(k, s1, s2):
    c = Counter(k)
    c1 = Counter(s1)
    c2 = Counter(s2)

    m = 0
    a = 0
    b = 0
    for i in range(how(c, c1)):
        d = diff(c, i + 1, c1)
        q = how(d, c2)
        if i + q + 1 > m:
            a = i + 1
            b = q
            m = a + b

    return a, b


def build(k, s1, s2, a, b):
    c = Counter(k)
    c1 = Counter(s1)
    c2 = Counter(s2)

    s = s1 * a + s2 * b
    d = diff(c, a, c1)
    d = diff(d, b, c2)
    for k in d.keys():
        s += k * d[k]

    return s


if __name__ == '__main__':
    k = input()
    s1 = input()
    s2 = input()

    a1, b1 = count(k, s1, s2)
    a2, b2 = count(k, s2, s1)
    if a1 + b1 > a2 + b2:
        print(build(k, s1, s2, a1, b1))
    else:
        print(build(k, s2, s1, a2, b2))