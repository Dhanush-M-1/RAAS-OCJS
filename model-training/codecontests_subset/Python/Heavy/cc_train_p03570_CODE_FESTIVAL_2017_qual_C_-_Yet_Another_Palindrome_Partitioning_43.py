def main():
    import sys
    from bisect import bisect_left
    input = sys.stdin.readline

    S = input().rstrip('\n')
    N = len(S)

    A = [ord(s)-97 for s in S]
    H = [0] * (N+1)
    h2i = {}
    for i in range(N):
        H[i+1] = H[i] ^ (1 << A[i])
        if H[i+1] in h2i:
            h2i[H[i+1]].append(i+1)
        else:
            h2i[H[i+1]] = [i+1]

    dp = [N+1] * (N+1)
    dp[0] = 0
    pow2 = [2**i for i in range(26)]
    for i in range(N):
        h = H[i]
        if h in h2i:
            ii_list = h2i[h]
            ii = bisect_left(ii_list, i+1)
            if ii < len(ii_list):
                ii = ii_list[ii]
                if i:
                    dp[ii] = min(dp[ii], dp[i])
                else:
                    dp[ii] = 1
        for j in pow2:
            new_h = h ^ j
            if new_h in h2i:
                ii_list = h2i[new_h]
                ii = bisect_left(ii_list, i+1)
                if ii < len(ii_list):
                    ii = ii_list[ii]
                    dp[ii] = min(dp[ii], dp[i] + 1)
    print(dp[-1])


if __name__ == '__main__':
    main()
