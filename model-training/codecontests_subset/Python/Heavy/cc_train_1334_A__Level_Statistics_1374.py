def main():
    v = int(input())
    for i in range(v):
        c = int(input())
        data = [[int(s) for s in input().split()] for v in range(c)]
        c = -1
        l = -1
        s = True
        for k, v in data:
            if k == c and l != v:
                s = False
                break
            d = k - c
            ll = v - l
            l = v
            c = k
            if d < 0 or ll < 0:
                s = False
                break
            if d < ll:
                s = False
                break
        if s:
            print("YES")
        else:
            print("NO")


def convert(data):
    d = {}
    for k, v in enumerate(data):
        if v not in d:
            d[v] = []
        d[v].append(k)
    return d


if __name__ == "__main__":
    # sys.setrecursionlimit(10 ** 6)
    # threading.stack_size(10 ** 8)
    # t = threading.Thread(target=main)
    # t.start()
    # t.join()
    main()
