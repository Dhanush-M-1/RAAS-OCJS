def main():
    S = input()
    a = {j: i for i, j in enumerate('abcdefghijklmnopqrstuvwxyz')}
    pow2 = [2**i for i in range(26)]
    S = [pow2[a[i]] for i in S]

    parity = 0
    dict_parity = {0: 0}

    for i, s in enumerate(S):
        parity ^= s
        if parity in dict_parity:
            ans = min(i+1, dict_parity[parity]+1)
        else:
            ans = i+1
        ans = min(
            [ans]+[dict_parity.get(parity ^ j, ans)+1 for j in pow2])
        dict_parity[parity] = min(ans, dict_parity.get(parity, ans))
    print(ans)


main()