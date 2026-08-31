

n, s = map(int, input().split())

arr = list(map(int, input().split()))

def solv(arr, med):
    half = int(len(arr) / 2)
    sm = []
    gt = []
    for item in arr:
        if item < med:
            sm.append(item)
        elif item > med:
            gt.append(item)
    if len(sm) <= half and len(gt) <= half:
        return 0
    elif len(sm) > half:
        sm.sort(reverse=True)
        li = sm[: len(sm) - half]
        result = 0
        for item in li:
            result += (med - item)
    else:
        gt.sort()
        li = gt[: len(gt) - half]
        result = 0
        for item in li:
            result += (item - med)

    return result

print(solv(arr, s))
