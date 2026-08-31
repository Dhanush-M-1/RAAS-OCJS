t = int(input())
for aaaaaaaaa in range(t):
    enter = input()
    y = []
    knm = [int(i) for i in input().split()]
    n = [int(i) for i in input().split()]
    m = [int(i) for i in input().split()]
    k = knm[0]
    n.append(301)
    m.append(301)
    l = 0
    for i in range(knm[1] + knm[2]):
        if n[0] == 0:
            y.append(0)
            k += 1
            del n[0]
        elif m[0] == 0:
            y.append(0)
            k += 1
            del m[0]
        elif k >= n[0]:
            y.append(n[0])
            del n[0]
        elif k >= m[0]:
            y.append(m[0])
            del m[0]
        elif n[0] == 301:
            enter = ""
        elif m[0] == 301:
            enter = ""
        else:
            print(-1)
            l = 1
            break
    if knm[1] + knm[2] > len(y) and l == 0:
        print(-1)
    else:
        if l == 0:
            for i in range(len(y)):
                enter += str(y[i]) + " "
            print(enter)