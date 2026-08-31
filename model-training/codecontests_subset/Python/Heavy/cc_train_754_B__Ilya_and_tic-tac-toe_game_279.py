bord = [input() for _ in range(4)]

s = [(bord[0][2], bord[1][1], bord[2][0]),
    (bord[0][3], bord[1][2], bord[2][1]),
    (bord[1][2], bord[2][1], bord[3][0]),
    (bord[1][3], bord[2][2], bord[3][1]),

    (bord[0][0], bord[1][1], bord[2][2]),
    (bord[1][1], bord[2][2], bord[3][3]),
    (bord[1][0], bord[2][1], bord[3][2]),
    (bord[0][1], bord[1][2], bord[2][3])]

for i in bord:
    s.append((i[0], i[1], i[2]))
    s.append((i[1], i[2], i[3]))

diffrent_bord = ["", "", "", ""]
for j in range(4):
    for k in range(4):
        diffrent_bord[k] += bord[j][k]

for i in diffrent_bord:
    s.append((i[0], i[1], i[2]))
    s.append((i[1], i[2], i[3]))


if {('.', 'x', 'x'), ('x', 'x', '.'), ('x', '.', 'x')} & (set(s)):
    print("YES")

else:
    print("NO")

