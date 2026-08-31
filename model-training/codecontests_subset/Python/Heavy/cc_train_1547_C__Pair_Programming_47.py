t = int(input())
for _ in range(t):
    d = input()
    knm = list(map(int, input().split()))
    k = knm[0]
    n = knm[1]
    m = knm[2]
    an = list(map(int, input().split()))
    am = list(map(int, input().split()))
    b = [1 for _ in range(k)]
    c = []
    k = True
    for i in range(n + m):
        if len(an) > 0 and an[0] == 0:
            b.append(1)
            c.append(an[0])
            del an[0]
        elif len(am) > 0 and am[0] == 0:
            b.append(1)
            c.append(am[0])
            del am[0]
        else:
            if (len(an) > 0 and an[0] > len(b)) and (len(am) > 0 and am[0] > len(b)):
                print(-1)
                k = False
                break
            elif len(an) > 0 and an[0] <= len(b):
                c.append(an[0])
                del an[0]
            elif len(am) > 0 and am[0] <= len(b):
                c.append(am[0])
                del am[0]
    if k:
        if len(c) == n + m:
            print(" ".join(list(map(str, c))))
        else:
            print(-1)