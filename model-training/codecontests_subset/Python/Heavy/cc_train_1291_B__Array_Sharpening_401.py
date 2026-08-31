def inp(dtype=str, strip=True):
    s = input()
    res = [dtype(p) for p in s.split()]
    res = res[0] if len(res) == 1 and strip else res
    return res


def problemA():
    t = int(input())
    for _ in range(t):
        n = int(input())
        s = input()
        s = [int(el) for el in s]

        res = '-1'
        cum = sum(s)
        i = 1
        while i <= n:
            if s[-i] % 2 != 0 and cum % 2 == 0:
                res = ''.join([str(s[j]) for j in range(n - i + 1)])
                break
            cum -= s[-i]
            i += 1

        print(res)


def problemB():
    t = int(input())
    for tcase in range(t):
        n = int(input())
        a = inp(int, strip=False)

        next = a[0] + 1 if a[0] <= 0 else 1
        i = 1
        while i < n and a[i] >= next:
            if a[i] < 0:
                next = a[i] + 1
            elif next <= 0:
                next = 1
            else:
                next += 1
            i += 1

        if i == n:
            print('YES')
            continue

        ileft = i - 1
        gapleft = a[ileft] < next - 1

        i = n - 1
        next = a[i] + 1 if a[i] <= 0 else 1
        i -= 1
        while i >= 0 and a[i] >= next:
            if a[i] < 0:
                next = a[i] + 1
            elif next <= 0:
                next = 1
            else:
                next += 1
            i -= 1

        if i < 0:
            print('YES')
            continue

        iright = i + 1
        gapright = a[iright] < next - 1

        # print(tcase, ileft, iright)

        if ileft + 1 > iright:
            print('YES')
        elif ileft + 1 == iright:
            if a[ileft] != a[iright]:
                print('YES')
            elif a[ileft] > 0 and (gapleft or gapright):
                print('YES')
            else:
                print('NO')
        else:
            print('NO')





if __name__ == '__main__':
    # problemA()
    problemB()
