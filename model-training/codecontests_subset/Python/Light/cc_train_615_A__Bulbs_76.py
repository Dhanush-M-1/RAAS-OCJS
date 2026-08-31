def solve(m, s):
    return "YES" if m == len(s) else "NO"


def main():
    n, m = list(map(int, input().split()))
    s = set()
    for _ in range(n):
        a = list(map(int, input().split()))
        s = s.union(a[1:]) 
    print(solve(m, s))


main()
