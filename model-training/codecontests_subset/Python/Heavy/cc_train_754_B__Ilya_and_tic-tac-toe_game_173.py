ttt = []

xs = []

mA = [-2, -2, -2, 0, 0, 2, 2, 2]
mB = [-2, 0, 2, -2, 2, -2, 0, 2]
mA2 = [-1, -1, -1, 0, 0, 1, 1, 1]
mB2 = [-1, 0, 1, -1, 1, -1, 0, 1]

for a in range(4):
    red = input()
    ttt.append(red)
    for b in range(4):
        if red[b] == "x":
            xs.append([a, b])

def isFree(a, b):
    if a>= 0 and b>= 0 and a <=3 and b<=3:
        return 1
    else:
        return 0

sol = "NO"

for pos in xs:
    pa = pos[0]
    pb = pos[1]
    for mo in range(8):
        pa1 = pa+mA[mo]
        pb1 = pb+mB[mo]
        if isFree(pa1, pb1):
            pa2 = pa+mA2[mo]
            pb2 = pb+mB2[mo]
            if ttt[pa2][pb2] == "." and ttt[pa1][pb1] == "x" or ttt[pa2][pb2] == "x" and ttt[pa1][pb1] == ".":
                sol = "YES"
                break
    if sol == "YES":
        break

print(sol)
