def main():
    m, n = [int(v) for v in input().split()]
    vals = [int(v) for v in input().split()]
    data = {}
    data[0] = list()
    for v in vals:
        d = v
        count = 0
        while d != 0:
            if d not in data:
                data[d] = list()
            data[d].append(count)
            count += 1
            d = d // 2
        data[d].append(count)
    min_v = 1000000000
    for k, v in data.items():
        if len(v) >= n:
            v.sort()
            d = sum(v[0:n])
            if d < min_v:
                min_v = d

    print(min_v)


if __name__ == "__main__":
    main()
