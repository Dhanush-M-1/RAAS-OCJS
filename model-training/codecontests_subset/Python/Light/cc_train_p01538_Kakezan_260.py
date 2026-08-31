def solve(n):
    ans = 0
    mp = {}
    while (n >= 10):
        s = str(n)
        next = -1
        for i in range(1, len(s)):
            next = max(next, int(s[0:i])*int(s[i:]))
        if next in mp:
            ans = -1
            break
        mp[next] = True
        n = next
        ans += 1
    return ans


def main():
    q = int(input())
    for i in range(q):
        n = int(input())
        print(solve(n))


main()

