TC = int(input())


def update_ch(precalc, last, i, ch):
    last_idx = last[ch]
    cur = 0 if last_idx == -1 else precalc[ch][last_idx]
    for j in range(last_idx + 1, i):
        precalc[ch][j] = cur
    precalc[ch][i] = cur + 1
    last[ch] = i


def solve(s, p):
    s = [ord(ch) - ord('a') for ch in s]
    p = [v - 1 for v in p]
    precalc = [[0] * len(s) for _ in range(26)]
    last = [-1] * 26
    for i in range(len(s)):
        update_ch(precalc, last, i, s[i])

    for ch in range(26):
        if last[ch] != -1:
            for j in range(last[ch] + 1, len(s)):
                precalc[ch][j] = precalc[ch][j - 1]

    res = [0] * 26

    for ch in range(26):
        for success in p:
            res[ch] += precalc[ch][success]
        res[ch] += precalc[ch][-1]

    return res


for _ in range(TC):
    n, m = map(int, input().split())
    s = input()
    p = [int(v) for v in input().split()]
    print(*solve(s, p))
