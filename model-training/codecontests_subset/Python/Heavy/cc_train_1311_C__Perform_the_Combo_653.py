
q = int(input())
for i in range(q):
    n, m = [int(i) for i in input().split()]
    s = input()
    p = sorted([int(i) for i in input().split()])
    ans = [0 for i in range(26)]
    it = 0

    for i in range(len(s)):
        ans[ord(s[i]) - ord('a')] += len(p) - it + 1
        if it == len(p):
            continue
        if p[it] - 1 == i:
            it += 1
            if it == len(p):
                continue
            while p[it] == p[it - 1]:
                it += 1
                if it == len(p):
                    break

    for i in range(len(ans)):
        print(ans[i], end=' ')
    print()
