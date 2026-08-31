def merge_neg_one(arr):
    merged = []
    for idx, item in enumerate(arr):
        if idx == 0:
            merged.append(item)
            continue
        if merged[-1] == -1 and item == -1:
            continue
        merged.append(item)
    return merged


def problem2(arr):
    arr_nonzero = list(filter(lambda x: x != -1, arr))
    if len(arr_nonzero) == 0:
        return "0 0"

    candidates = [min(arr_nonzero), max(arr_nonzero)]
    merged = merge_neg_one(arr)
    for idx, item in enumerate(merged):
        if item == -1:
            if idx == 0:
                continue
            if idx == len(merged)-1:
                continue

            if merged[idx-1] != -1 and merged[idx+1] != -1:
                candidates.append(int((merged[idx-1] + merged[idx+1]) / 2))

    min_max_adj_diff = 1000000000
    ans = None
    malformed = False
    for candidate in candidates:
        max_adj_diff = 0
        for idx, item in enumerate(arr):
            if idx == len(arr) - 1:
                break
            a = arr[idx]
            b = arr[idx+1]
            if a == -1:
                a = candidate
            if b == -1:
                b = candidate
            adj_diff = abs(a - b)
            if adj_diff > max_adj_diff:
                max_adj_diff = adj_diff
                if a == arr[idx] and b == arr[idx+1]:
                    malformed = True
                else:
                    malformed = False

        if max_adj_diff < min_max_adj_diff:
            min_max_adj_diff = max_adj_diff
            ans = candidate
            if malformed:
                ans = min(candidates)

    return f"{min_max_adj_diff} {ans}"


def problem2_1(arr):
    maxn = 0
    minn = 1000000000
    for idx, item in enumerate(arr):

        if idx > 0 and item == -1 and arr[idx-1] != -1:
            if maxn < arr[idx-1]:
                maxn = arr[idx-1]
            if minn > arr[idx-1]:
                minn = arr[idx-1]

        if idx < len(arr)-1 and item == -1 and arr[idx+1] != -1:
            if maxn < arr[idx+1]:
                maxn = arr[idx+1]
            if minn > arr[idx+1]:
                minn = arr[idx+1]

    ans = int((minn + maxn) / 2)

    max_adj_diff = 0
    for idx, item in enumerate(arr):
        if idx == 0:
            continue
        a = arr[idx-1]
        if a == -1:
            a = ans
        b = arr[idx]
        if b == -1:
            b = ans
        adj_diff = abs(a - b)
        if adj_diff > max_adj_diff:
            max_adj_diff = adj_diff

    return f"{max_adj_diff} {ans}"


N = int(input())
for i in range(N):
    num = input()
    arr = list(map(lambda x: int(x), input().split(" ")))
    print(problem2_1(arr))
