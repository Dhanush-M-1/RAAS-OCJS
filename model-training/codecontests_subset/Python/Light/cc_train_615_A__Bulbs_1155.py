

def solve():
    n, m =[int(s) for s in input().split()]
    l = set()

    for i in range(n):
        x, *y = [int(s) for s in input().split()]
        l.update(y)

    if len(l) == m:
        print("YES")
    else:
        print("NO")


if __name__ == "__main__":
    solve()