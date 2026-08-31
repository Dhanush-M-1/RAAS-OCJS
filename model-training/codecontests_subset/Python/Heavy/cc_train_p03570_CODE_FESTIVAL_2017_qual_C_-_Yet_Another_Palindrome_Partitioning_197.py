from string import ascii_lowercase

cd = {c: 1 << i for i, c in enumerate(ascii_lowercase)}
bt = set(cd.values())
bt.add(0)


def solve(s):
    a, b = [], 0
    for c in s:
        b ^= cd[c]
        a.append(b)
    if a[-1] == 0:
        return 1

    dp = {0: 0}
    for b1 in a:
        for b2 in bt:
            b3 = b1 ^ b2
            if b3 not in dp:
                continue
            if b1 in dp:
                dp[b1] = min(dp[b1], dp[b3] + 1)
            else:
                dp[b1] = dp[b3] + 1
    return dp[a[-1]]


print(solve(input()))
