import math


def inp(dtype=str, strip=True):
    s = input()
    res = [dtype(p) for p in s.split()]
    res = res[0] if len(res) == 1 and strip else res
    return res


def problem1():
    n = inp(int)
    s = inp()

    print(n + 1)


def problem2():
    t = inp(int)
    for _ in range(t):
        n = inp(int)
        a = inp(int, strip=False)

        s1 = sum(a)

        def search(b):
            mx, cur = -10 ** 10, 0
            # print('b=', b)
            for el in b:
                cur += el
                # print('o', el, cur, mx)
                if cur > mx:
                    mx = cur
                if cur < 0:
                    cur = 0
            return mx

        # print(a, s1, search(a[:-1]), search(a[1:]))
        s2 = max(search(a[:-1]), search(a[1:]))
        if s1 > s2:
            print('YES')
        else:
            print('NO')


def problem3():
    x_raw = inp(int)

    x = x_raw
    p, k = [], []
    for j in range(2, int(math.sqrt(x)) + 2):
        power = 0
        while x % j == 0:
            x = x // j
            power += 1
        if power > 0:
            p.append(j)
            k.append(power)
    if x > 1:
        p.append(x)
        k.append(1)

    # print(p, k)

    def find(p, k, pos, tp):
        if pos == len(p):
            x1, x2 = 1, 1
            for i in range(len(p)):
                num = p[i] ** k[i]
                if tp[i]:
                    x1 *= num
                else:
                    x2 *= num
            # print(x1, x2)
            return max(x1, x2)

        tp[pos] = 0
        res1 = find(p, k, pos + 1, tp)
        tp[pos] = 1
        res2 = find(p, k, pos + 1, tp)
        return min(res1, res2)

    tp = [0 for i in range(len(p))]
    res = find(p, k, 0, tp)
    print(res, x_raw // res)


def problem4():
    n = inp(int)
    a = inp(int, strip=False)
    a = [bin(el)[2:] for el in a]
    a = [[int(s) for s in el] for el in a]
    m = max([len(el) for el in a])

    a = [[0 for _ in range(m - len(el))] + el for el in a]
    res = [0 for _ in range(m)]

    def solve(p, r, pos):
        if pos == m:
            return 0

        n1 = sum([el[pos] for el in a[p:r+1]])
        if n1 == 0:
            res[pos] = 0
            return solve(p, r, pos + 1)
        elif n1 == r - p + 1:
            res[pos] = 1
            return solve(p, r, pos + 1)
        else:
            # both zeros and ones
            q = r - n1
            k0 = solve(p, q, pos + 1)
            k1 = solve(q + 1, r, pos + 1)

            if k0 < k1:
                res[pos] = 1
                return 2 ** (m - pos - 1) + k0
            else:
                res[pos] = 0
                return 2 ** (m - pos - 1) + k1

    res = solve(0, len(a) - 1, 0)
    print(res)


if __name__ == '__main__':
    # problem1()
    # problem2()
    problem3()
    # problem4()
