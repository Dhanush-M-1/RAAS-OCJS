def solve():
    n = int(input())
    d = [list(input()) for i in range(n)]
    cnt1 = 0
    que1 = []
    if d[0][1] != "1":
        cnt1 += 1
        que1.append((1, 2))
    if d[1][0] != "1":
        cnt1 += 1
        que1.append((2, 1))
    if d[-2][-1] != "0":
        cnt1 += 1
        que1.append((n-1, n))
    if d[-1][-2] != "0":
        cnt1 += 1
        que1.append((n, n-1))
    if cnt1 <= 2:
        print(cnt1)
        for x, y in que1:
            print(x, y)
        return

    cnt1 = 0
    que1 = []
    if d[0][1] != "0":
        cnt1 += 1
        que1.append((1, 2))
    if d[1][0] != "0":
        cnt1 += 1
        que1.append((2, 1))
    if d[-2][-1] != "1":
        cnt1 += 1
        que1.append((n-1, n))
    if d[-1][-2] != "1":
        cnt1 += 1
        que1.append((n, n-1))
    if cnt1 <= 2:
        print(cnt1)
        for x, y in que1:
            print(x, y)
        return


def main():
    t = int(input())
    for i in range(t):
        solve()
    return


if __name__ == "__main__":
    main()
