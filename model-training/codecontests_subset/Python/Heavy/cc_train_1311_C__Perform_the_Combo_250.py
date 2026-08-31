from sys import stdin
r= stdin.readline

def ascii(c): return ord(c)-97

def solve(t, p, n, m):
    ac, cnt = dict(), []
    for i in range(n):
        if t[i] not in ac: ac[t[i]] = 1
        else: ac[t[i]]+=1
        cnt.append(ac.copy())
    ans = [0 for _ in range(26)]
    p.append(n)
    for i in range(m+1):
        x = p[i]-1
        count = cnt[x]
        for c in count:
            ans[ascii(c)] += count[c]
    return ans




def main():
    cases = int(r())
    for case in range(cases):
        n, m = map(int, r().strip().split())
        t = r().strip()
        p = list(map(int, r().strip().split()))
        print(*solve(t, p, n, m))

main()