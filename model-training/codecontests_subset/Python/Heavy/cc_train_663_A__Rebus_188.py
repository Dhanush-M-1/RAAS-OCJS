from collections import Counter


def solve():
    s = input()
    s = '+ ' + s
    ls = s.split()

    n = int(ls[-1])

    ops = [ls[i * 2] for i in range(len(ls) // 2 - 1)]
    nop = len(ops)

    c = Counter(ops)
    p = c['+']
    m = c['-']

    ma = n * p - 1 * m
    mi = 1 * p - n * m

    if not (mi <= n <= ma):
        print('Impossible')
        return

    x = (ma - n) // (p + m)
    mae = [(n - x) if o == '+' else (1 + x) for o in ops]

    ma -= x * (p + m)

    i = 0
    while ma > n:
        if ops[i % nop] == '+':
            mae[i % nop] -= 1
        else:
            mae[i % nop] += 1
        i += 1
        ma -= 1

    ans = []
    for i in range(nop):
        ans.append(ops[i])
        ans.append(str(mae[i]))
    ans.append('=')
    ans.append(str(n))

    print('Possible')
    print(' '.join(ans[1:]))


if __name__ == '__main__':
    solve()
