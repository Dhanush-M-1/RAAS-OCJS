from sys import stdin, stdout

t = int(stdin.readline())
while t>0:
    n = int(stdin.readline())
    stat = []
    for i in range(n):
        p, c = map(int,stdin.readline().split())
        stat.append([p,c])
    curP, curC = stat[0][0],stat[0][1]
    correct = True
    if curC>curP:
        correct = False
    
    for i in range(1,n):
        p, c = stat[i][0], stat[i][1]
        if p>curP:
            d = p-curP
            if c<curC:
                correct = False
                break
            if c>(curC+d):
                correct = False
                break
        elif p<curP or c<curC:
            correct = False
            break
        elif p==curP and (c>curC or c<curC):
            correct = False
            break
        curP = p
        curC = c
    if correct:
        stdout.write("YES\n")
    else:
        stdout.write("NO\n")
    t-=1