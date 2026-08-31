import sys
from array import array  # noqa: F401
from typing import List, Tuple, TypeVar, Generic, Sequence, Union  # noqa: F401


def input():
    return sys.stdin.buffer.readline().decode('utf-8')


def main():
    n = int(input())
    a = [-1] + [ord(c) - 97 for c in input().rstrip()]
    char_cnt = [array('h', [0]) * (n + 1) for _ in range(26)]
    for i in range(1, n + 1):
        for j in range(26):
            char_cnt[j][i] = char_cnt[j][i - 1]
        char_cnt[a[i]][i] += 1

    q = int(input())
    ans = array('h', [0]) * q
    dp = [array('h', [0]) * (n + 1) for _ in range(26)]

    for qi in range(q):
        m, c = input().split()
        m = int(m)
        c = ord(c) - 97

        if dp[c][m]:
            ans[qi] = dp[c][m]
            continue

        ok, ng = m, n + 1
        while abs(ok - ng) > 1:
            mid = (ok + ng) >> 1
            for l, r in zip(range(n), range(mid, n + 1)):
                if char_cnt[c][r] - char_cnt[c][l] + m >= mid:
                    ok = mid
                    break
            else:
                ng = mid

        dp[c][m] = ans[qi] = ok

    sys.stdout.buffer.write('\n'.join(map(str, ans)).encode('utf-8'))


if __name__ == '__main__':
    main()
