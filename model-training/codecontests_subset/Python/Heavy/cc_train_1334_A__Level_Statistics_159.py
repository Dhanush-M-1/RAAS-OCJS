R = lambda: map(int, input().split())


def solver(n, arr):
    prev = [0, 0]
    for i in range(n):
        cur = arr[i]
        diff_play, diff_clear = cur[0] - prev[0], cur[1] - prev[1]
        if diff_play < 0 or diff_clear < 0:
            return False
        if diff_clear > diff_play:
            return False
        prev = cur
    return True


def main():
    T = int(input())
    for t in range(1, T + 1):
        # test case
        n = int(input())
        pairs = []
        for _ in range(n):
            pairs.append(list(R()))

        ans = "YES" if solver(n, pairs) else "NO"
        print(ans)


main()
