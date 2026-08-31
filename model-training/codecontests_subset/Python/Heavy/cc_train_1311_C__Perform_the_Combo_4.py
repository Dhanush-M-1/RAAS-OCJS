def print_a(a):
    for i in a:
        print(i, end=' ')
    print()


def solve(n, m, s, p):
    p.sort(reverse=True)
    ans = [1] * n
    i = 0
    while i < len(p):
        j = i
        while j < len(p) and p[j] == p[i]:
            j += 1
        if j == len(p):
            l, r = 0, p[i]
        else:
            l, r = p[j], p[i]
        inc = j
        for it in range(l + 1, r + 1):
            ans[it-1] += inc
        i = j
    res = [0] * 26
    for i in range(n):
        c = ord(s[i]) - ord('a')
        res[c] += ans[i]
    print_a(res)


def main():
    inp = lambda: [int(x) for x in input().split()]
    tc = int(input())
    for _ in range(tc):
        n, m = inp()
        s = input()
        p = inp()
        solve(n, m, s, p)


if __name__ == "__main__":
    main()

