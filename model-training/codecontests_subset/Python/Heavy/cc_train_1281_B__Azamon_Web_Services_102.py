def solveOne(me, rival):
    SMALLER, EQUAL, BIGGER = range(3)

    if me < rival:
        return ''.join(me)
    n = min(len(me), len(rival))
    compare = [[EQUAL for _ in range(n)] for _ in range(n)]
    for i in range(n):
        if me[i] < rival[i]:
            compare[i][i] = SMALLER
        elif me[i] > rival[i]:
            compare[i][i] = BIGGER
        else:
            compare[i][i] = EQUAL
    for left in range(n):
        for right in range(left + 1, n):
            if compare[left][right - 1] != EQUAL:
                compare[left][right] = compare[left][right - 1]
            elif me[right] < rival[right]:
                compare[left][right] = SMALLER
            elif me[right] > rival[right]:
                compare[left][right] = BIGGER
            else:
                compare[left][right] = EQUAL

    def isLess():
        for seg in ((0, min(i - 1, n - 1)),
                    (i, ),
                    (i + 1, min(j - 1, n - 1)),
                    (j, ),
                    (j + 1, n - 1)):
            if len(seg) == 2:
                left, right = seg
                if right >= left:
                    if compare[left][right] == SMALLER:
                        return True
                    if compare[left][right] == BIGGER:
                        return False
            else:
                pos = seg[0]
                if pos < len(rival):
                    if rival[pos] > me[pos]:
                        return True
                    if rival[pos] < me[pos]:
                        return False
        return len(me) < len(rival)

    for i in range(len(me)):
        for j in range(i + 1, len(me)):
            if me[i] > me[j]:
                me[i], me[j] = me[j], me[i]
                if isLess():
                    return ''.join(me)
                else:
                    me[i], me[j] = me[j], me[i]
    return '---'


for _ in range(int(input())):
    print(solveOne(*map(list, input().split())))