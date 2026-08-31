def solve(n, a):
    a, b, c = a[0], a[1], a[-1]
    if a + b > c:
        print(-1)
    else:
        print(1, 2, n)
    return

def main():
    inp = lambda: [int(x) for x in input().split()]
    tc = int(input())
    for _ in range(tc):
        n, a = int(input()), inp()
        solve(n, a)

if __name__ == '__main__':
    main()
