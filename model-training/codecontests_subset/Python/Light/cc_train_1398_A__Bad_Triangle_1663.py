def solve():
    n = int(input())
    a = [int(x) for x in input().split(' ')]
    if a[0] + a[1] <= a[n-1]: print(1, 2, n)
    else: print(-1)

def main():
    T = int(input())
    while T > 0:
        T -= 1
        solve()

main()