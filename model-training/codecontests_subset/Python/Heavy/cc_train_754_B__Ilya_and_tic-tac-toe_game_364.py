field = [input(), input(), input(), input()]

def printAnswer(b):
    if b: print("YES")
    else: print("NO")
    exit()

def checkH(field, x, y):
    xx = oo = 0
    for i in range(x, x+3):
        if field[y][i] == 'x':
            xx+=1
        elif field[y][i] == 'o':
            oo+=1

    if xx == 2 and oo == 0:
        printAnswer(True)
    return False

def checkV(field, x, y):
    xx = oo = 0
    for i in range(y, y+3):
        if field[i][x] == 'x':
            xx+=1
        elif field[i][x] == 'o':
            oo+=1

    if xx == 2 and oo == 0:
        printAnswer(True)
    return False

def checkD(field, x, y):
    xx = oo = 0
    for d in range(0, 3):
        if field[y+d][x+d] == 'x':
            xx+=1
        elif field[y+d][x+d] == 'o':
            oo+=1

    if xx == 2 and oo == 0:
        printAnswer(True)
    return False

def checkRD(field, x, y):
    xx = oo = 0
    for d in range(0, 3):
        if field[y+d][x-d+2] == 'x':
            xx+=1
        elif field[y+d][x-d+2] == 'o':
            oo+=1

    if xx == 2 and oo == 0:
        printAnswer(True)
    return False


for i in range(0,4):
    checkH(field, 0,i)
    checkH(field, 1,i)

    checkV(field, i,0)
    checkV(field, i,1)

    checkD(field, i%2, int(i/2))
    checkRD(field, i%2, int(i/2))

printAnswer(False)