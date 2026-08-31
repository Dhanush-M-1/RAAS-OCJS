def check(a, b, c):
    s = a + b + c
    if s == 'xx.' or s == '.xx' or s == 'x.x':
        return True
    return False

a = [[] for _ in range(4)]
for i in range(4):
    a[i] = input()

win = False
for i in range(4):
    for j in range(4):
        # to the right
        if j + 2 < 4:
            if check(a[i][j], a[i][j+1], a[i][j+2]):
                win = True
        # to the bottom
        if i + 2 < 4:
            if check(a[i][j], a[i+1][j], a[i+2][j]):
                win = True
        # diagonal 1
        if i + 2 < 4 and j + 2 < 4:
            if check(a[i][j], a[i+1][j+1], a[i+2][j+2]):
                win = True
        # diagonal 2
        if i + 2 < 4 and j - 2 >= 0:
            if check(a[i][j], a[i+1][j-1], a[i+2][j-2]):
                win = True
print("YES") if win else print("NO")