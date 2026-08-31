def solve(f, g):
    found = False
    for item in f:
        if item in g:
            l = 1
            item = item
            found = True
            break
    if found:
        print("YES")
        print("{} {}".format(1, item))
    else:
        print("NO")


def main():
    for i in range(int(input())):
        n, h = map(int, input().split())
        f = [int(x) for x in input().split()]
        g = [int(x) for x in input().split()]
        solve(f, g)


if __name__ == "__main__":
    main()
