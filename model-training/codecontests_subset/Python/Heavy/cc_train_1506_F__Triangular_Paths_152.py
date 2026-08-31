def main():
    t = int(input())
    for _ in range(t):
        n = int(input())
        r = list(map(int, input().split()))
        c = list(map(int, input().split()))
        rc = []
        for i in range(n):
            rc.append((r[i], r[i] - c[i] + 1))
        rc.sort(key = lambda x : x[0])
        pos = (1, 1); total = 0
        for i in range(n):
            nxt = rc[i]
            if nxt[0] == 1:
                continue
            dy = nxt[0] - pos[0]
            if pos[1] == nxt[1]:
                if pos[1] % 2:
                    total += dy
            else:
                dx = nxt[1] - pos[1]
                if dx % 2:
                    if pos[1] % 2 == 0:
                        total += 1
                    dx -= 1
                total += dx // 2
            pos = nxt
        print(total)
main()