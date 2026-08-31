import array
import itertools
import sys
import time


MOD = 998_244_353


def main():
    st = time.time()
    n, k = list(map(int, input().split()))
    all_input = array.array('L', map(int, sys.stdin.read().split()))
    l, r = all_input[::2], all_input[1::2]

    print('Read', time.time() - st, file=sys.stderr)

    fact = array.array('L', [1] * (n + 1))
    rev = array.array('L', [1] * (n + 1))
    r_fact = array.array('L', [1] * (n + 1))
    for i in range(2, n + 1):
        fact[i] = fact[i - 1] * i % MOD
        rev[i] = (MOD - MOD // i * rev[MOD % i] % MOD) % MOD
        r_fact[i] = r_fact[i - 1] * rev[i] % MOD

    print('Fact', time.time() - st, file=sys.stderr)

    sorted_events = sorted(itertools.chain(
        (pos * 2 for pos in l),
        (pos * 2 + 1 for pos in r)
    ))

    print('Sort', time.time() - st, file=sys.stderr)

    cnt = 0
    res = 0
    for typ, grp in itertools.groupby(sorted_events):
        grp_cnt = sum(1 for _ in grp)
        if typ % 2 == 0:
            res -= fact[cnt] * r_fact[cnt - k] if cnt >= k else 0
            cnt += grp_cnt
            res += fact[cnt] * r_fact[cnt - k] if cnt >= k else 0
        else:
            cnt -= grp_cnt

    print('Calc', time.time() - st, file=sys.stderr)

    print(res * r_fact[k] % MOD)


if __name__ == '__main__':
    main()
