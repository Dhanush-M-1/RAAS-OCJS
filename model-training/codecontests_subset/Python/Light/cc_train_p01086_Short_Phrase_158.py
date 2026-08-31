target = [5,7,5,7,7]
while True:
    N = int(input())
    if N == 0: break
    src = [len(input()) for i in range(N)]
    ans = -1
    for i in range(N):
        j = i
        _t = target[::-1]
        while True:
            if src[j] > _t[-1]: break
            if src[j] == _t[-1]:
                _t.pop()
                if len(_t) == 0:
                    ans = i+1
                    break
            else:
                _t[-1] -= src[j]
            j += 1
        if ans >= 0:
            print(ans)
            break