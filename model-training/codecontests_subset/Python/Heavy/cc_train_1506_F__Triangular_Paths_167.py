import sys

input = sys.stdin.readline


def main():
    t = int(input())
    for _ in range(t):
        n = int(input())
        r = list(map(int, input().split()))
        c = list(map(int, input().split()))
        points = [(r[i], c[i]) for i in range(n)]
        points.sort(key=lambda x: x[0])
        if points[0] != (1, 1):
            points = [(1, 1)] + points
            n += 1
        cost = 0
        for i in range(n - 1):
            prev = points[i]
            now = points[i + 1]
            prev_diff = prev[0] - prev[1]
            now_diff = now[0] - now[1]
            if prev_diff == now_diff:
                if prev_diff % 2 == 0:
                    cost += now[0] - prev[0]
                else:
                    pass
            elif prev_diff + 1 == now_diff and prev_diff % 2 == 0:
                pass
            else:
                cost += now_diff // 2 - prev_diff // 2
        print(cost)


if __name__ == '__main__':
    main()
