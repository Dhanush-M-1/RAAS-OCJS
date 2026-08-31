T = int(input())
for x in range(T):
    N  = int(input())
    p = []
    c = []
    correct = True
    for i in range(N):
        pi, ci = map(int, input().split())
        p.append(pi)
        c.append(ci)
        if(i > 0):
            if(pi < p[i-1] or ci < c[i-1]):
                correct = False
            elif((ci - c[i-1] > (pi - p[i-1]))):
                correct = False
        else:
            if(ci > pi or ci < 0 or pi < 0):
                correct = False
    if(correct):
        print('YES')
    else:
        print('NO')