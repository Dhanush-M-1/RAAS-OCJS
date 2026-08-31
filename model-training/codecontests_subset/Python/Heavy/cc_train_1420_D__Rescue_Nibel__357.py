import array
import collections
import itertools
import sys
import time


MOD = 998_244_353


def main():
    st = time.time()
    n, k = list(map(int, input().split()))
    all_input = list(map(int, sys.stdin.read().split()))

    print('Read', time.time() - st, file=sys.stderr)

    rev = array.array('L', [1] * (n + 1))
    for i in range(2, n + 1):
        quot, rem = divmod(MOD, i)
        rev[i] = -quot * rev[rem] % MOD  # ignore global `% MOD`

    c_nk = array.array('L', [0] * (n + 1))
    c_nk[k] = 1
    for i in range(k + 1, n + 1):
        c_nk[i] = c_nk[i - 1] * i * rev[i - k] % MOD

    print('Binom', time.time() - st, file=sys.stderr)

    events = collections.Counter(sorted(itertools.chain(
        (pos * 2 for pos in all_input[::2]),
        (pos * 2 + 1 for pos in all_input[1::2]),
    )))

    print('Sort', time.time() - st, file=sys.stderr)

    cnt = 0
    res = 0
    for typ, grp_cnt in events.items():  # don't sort because of initial order
        if typ % 2 == 0:
            res -= c_nk[cnt]
            cnt += grp_cnt
            res += c_nk[cnt]
        else:
            cnt -= grp_cnt

    print('Calc', time.time() - st, file=sys.stderr)

    print(res % MOD)


if __name__ == '__main__':
    main()
