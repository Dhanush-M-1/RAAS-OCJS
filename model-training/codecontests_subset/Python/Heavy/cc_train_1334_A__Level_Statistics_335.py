from sys import stdin



T = int(input())

for _ in range(T):
    N = int(input())
    pc = []
    for _ in range(N):
        p, c = stdin.readline().split()
        pc.append((int(p), int(c)))
    if (len(pc) == 1):
        if (pc[0][0] >= pc[0][1]):
            print("YES")
        else:
            print("NO")
    else:
        if (pc[0][0] < pc[0][1]):
            print("NO")
            continue
        for i in range(1, len(pc)):
            if ((pc[i][0] < pc[i-1][0]) or (pc[i][1] < pc[i-1][1])):
                print("NO")
                i = -1
                break
            if (pc[i][0] < pc[i][1]):
                print("NO")
                i = -1
                break
            if ((pc[i][0] - pc[i-1][0]) < (pc[i][1] - pc[i-1][1])):
                print("NO")
                i = -1
                break
        if (i == len(pc)-1):
            print("YES")
        