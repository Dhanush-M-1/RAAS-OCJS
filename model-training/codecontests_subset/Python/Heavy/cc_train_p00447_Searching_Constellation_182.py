while True:
    m = int(input())
    if not m:
        break
    target = {tuple(map(int, input().split())) for _ in range(m)}
    base = min(target)
    target.remove(base)
    bx, by = base
    target = {(x - bx, y - by) for x, y in target}

    n = int(input())
    sky = {tuple(map(int, input().split())) for _ in range(n)}

    for x, y in sorted(sky):
        for tx, ty in target:
            if (x + tx, y + ty) not in sky:
                break
        else:
            print(x - bx, y - by)
            break