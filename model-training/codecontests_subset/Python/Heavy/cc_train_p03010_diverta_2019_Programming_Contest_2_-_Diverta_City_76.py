def solve(n):
    if n == 2:
        print('0 1\n1 0')
        return

    can = []
    ban = set()

    k = 1
    while len(can) < 9:
        if k in ban or any(k + l in ban for l in can):
            k += 1
            continue
        ban.add(k)
        ban.update(k + l for l in can)
        can.append(k)
        k += 1

    ans = [[0] * n for _ in [0] * n]
    ans[0][1] = ans[1][0] = 1
    longest_path = 1
    for i in range(2, n):
        np = longest_path + 1
        for j, c in zip(range(i), can):
            ans[i][j] = ans[j][i] = np * c
        longest_path += ans[i][i - 1] + ans[i][i - 2] - ans[i - 1][i - 2]

    print('\n'.join(' '.join(map(str, row)) for row in ans))


n = int(input())
solve(n)
