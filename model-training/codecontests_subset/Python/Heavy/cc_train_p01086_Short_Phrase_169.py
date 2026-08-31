def solve():
    n = int(input())
    if n == 0: return False

    ok = [5, 7, 5, 7, 7]

    inputs = [input() for x in range(n)]

    for i in range(n):
        target = 0
        cnt = i
        for v in ok:
            while target < v:
                s = inputs[cnt]
                target += len(s)
                cnt += 1
            if target != v:
                break
            else:
                target = 0
        else:
            print(i + 1)
            return True
    return True
while solve(): pass