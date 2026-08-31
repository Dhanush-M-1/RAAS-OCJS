kl = int(input())
for l in range(kl):

    n = int(input())
    s = [int(i) for i in input().split()]
    mxr = 0
    mnr = 1000000001
    d = 0
    for i in range(1, n):
        if s[i - 1] == -1 and s[i] == -1:
            continue
        elif s[i - 1] == -1 and s[i] != -1:
            mxr = max(mxr, s[i])
            mnr = min(mnr, s[i])
        elif s[i - 1] != -1 and s[i] == -1:
            mxr = max(mxr, s[i - 1])
            mnr = min(mnr, s[i - 1])
        elif s[i - 1] != -1 and s[i] != -1:
            d = max(d, abs(s[i] - s[i - 1]))
    k = mnr + (mxr - mnr) // 2
    print(max(d, mxr - k, k - mnr), k)