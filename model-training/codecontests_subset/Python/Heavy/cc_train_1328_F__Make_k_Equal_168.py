def main():
    m, n = [int(v) for v in input().split()]
    vals = [int(v) for v in input().split()]
    data = []
    for v in vals:
        res = {}
        d = v
        count = 0
        while d != 0:
            res[d] = count
            count += 1
            d = d // 2
        res[d] = count
        data.append(res)
    all_vals = set()
    for d in data:
        all_vals.update(set(d.keys()))
    results = {}
    for k in all_vals:
        sorted_res = sorted([d[k] for d in data if k in d])
        if len(sorted_res)>=n:
            results[k] = sum(sorted_res[0:n])
    print(min(results.values()))

if __name__ == "__main__":
    main()
