from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    n, k = map(int, input().split())

    al = []
    bl = []
    abl = []

    for _ in range(n):
        t, a, b = map(int, input().split())
        if a and b:
            abl.append(t)
        elif a:
            al.append(t)
        elif b:
            bl.append(t)

    al.sort()
    bl.sort()
    abl.sort()

    sl = list(map(lambda o: o[0] + o[1], zip(al, bl)))

    abl.reverse()
    sl.reverse()

    c = 0

    while abl and sl and k:
        if abl[-1] < sl[-1]:
            c += abl.pop()
        else:
            c += sl.pop()
        k -= 1

    if k:
        if len(abl) + len(sl) < k:
            print(-1)
        else:
            while k:
                if abl:
                    c += abl.pop()
                else:
                    c += sl.pop()
                k -= 1
            print(c)
    else:
        print(c)
