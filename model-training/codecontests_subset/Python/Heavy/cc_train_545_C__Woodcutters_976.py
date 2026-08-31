def main():
    l = list(tuple(map(int, input().split())) for _ in range(int(input())))
    l.append((10 ** 10, 0))
    nxt = {0: -10 ** 9}
    for (x1, h1), (x2, h2) in zip(l, l[1:]):
        cur, nxt = nxt, {}
        for cnt, mi in cur.items():
            if x1 - h1 > mi:
                if cnt + 1 in nxt:
                    nxt[cnt + 1].append(x1)
                else:
                    nxt[cnt + 1] = [x1]
            else:
                if cnt in nxt:
                    nxt[cnt].append(x1)
                else:
                    nxt[cnt] = [x1]
                if x1 + h1 < x2:
                    cnt += 1
                    if cnt in nxt:
                        nxt[cnt].append(x1 + h1)
                    else:
                        nxt[cnt] = [x1 + h1]
        for cnt, mi in nxt.items():
            nxt[cnt] = min(mi)
        tmp = []
        for cnt, mi in nxt.items():
            if any((cnt <= k and mi > v) or (cnt < k and mi >= v) for k, v in nxt.items()):
                tmp.append(cnt)
        for cnt in tmp:
            del nxt[cnt]

    print(max(nxt.keys()))


if __name__ == '__main__':
    main()
