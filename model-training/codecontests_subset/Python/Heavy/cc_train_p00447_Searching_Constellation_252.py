import operator

while True:
    m = int(input())
    if not m:
        break
    target = [tuple(map(int, input().split())) for _ in range(m)]
    bx, by = min(target)
    target = {(x - bx, y - by) for x, y in target}
    max_tx = max(map(operator.itemgetter(0), target))

    n = int(input())
    sky = {tuple(map(int, input().split())) for _ in range(n)}
    max_sx = max(map(operator.itemgetter(0), sky))

    lim_x = max_sx - max_tx

    for x, y in sky:
        if x > lim_x:
            continue
        for tx, ty in target:
            if (x + tx, y + ty) not in sky:
                break
        else:
            print(x - bx, y - by)
            break