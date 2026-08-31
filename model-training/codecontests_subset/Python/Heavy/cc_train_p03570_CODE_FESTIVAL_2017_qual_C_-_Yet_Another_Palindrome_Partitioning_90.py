def ctoi(c):
    return ord(c) - ord('a')

def solve(s):
    masks = [1<<k for k in range(26)]
    cums = [0]
    for c in s:
        cums.append(cums[-1] ^ masks[ctoi(c)])
    if cums[-1] == 0:
        print(1)
        exit()

    dp = {0:0}
    for b in cums:
        for m in masks:
            msk = b^m
            if msk in dp:
                if b in dp:
                    dp[b] = min(dp[b], dp[msk]+1)
                else:
                    dp[b] = dp[msk]+1
    return dp[cums[-1]]

print(solve(input()))