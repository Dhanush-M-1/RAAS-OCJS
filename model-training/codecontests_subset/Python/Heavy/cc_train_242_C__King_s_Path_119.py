from sys import stdin


def main():
    x, y, u, v = map(int, input().split())
    input()
    rows = set()
    for st in stdin.read().splitlines():
        r, a, b = map(int, st.split())
        rows.update((r, x) for x in range(a, b + 1))
    nxt, visited, cnt = [(x, y)], {(x, y)}, 0
    while nxt:
        cur, nxt = nxt, []
        for x, y in cur:
            if x == u and y == v:
                print(cnt)
                return
            for xy in (x - 1, y), (x + 1, y), (x, y - 1), (x, y + 1), (x - 1, y - 1), (x + 1, y - 1), (x - 1, y + 1), (
                    x + 1, y + 1):
                if xy in rows and xy not in visited:
                    visited.add(xy)
                    nxt.append(xy)
        cnt += 1
    print(-1)


if __name__ == '__main__':
    main()




# Made By Mostafa_Khaled