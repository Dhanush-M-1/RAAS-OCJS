"""Created by Kartik Patodi on 06-Jan-17"""

r1 = input()
r2 = input()
r3 = input()
r4 = input()
c1 = r1[0] + r2[0] + r3[0] + r4[0]
c2 = r1[1] + r2[1] + r3[1] + r4[1]
c3 = r1[2] + r2[2] + r3[2] + r4[2]
c4 = r1[3] + r2[3] + r3[3] + r4[3]
d1 = r1[0] + r2[1] + r3[2]
d2 = r1[1] + r2[2] + r3[3]
d3 = r1[2] + r2[1] + r3[0]
d4 = r1[3] + r2[2] + r3[1]
d5 = r2[0] + r3[1] + r4[2]
d6 = r2[1] + r3[2] + r4[3]
d7 = r2[2] + r3[1] + r4[0]
d8 = r2[3] + r3[2] + r4[1]

chk = [r1, r2, r3, r4, c1, c2, c3, c4, d1, d2, d3, d4, d5, d6, d7, d8]

for i in chk:
    if '.xx' in i or 'xx.' in i or 'x.x' in i:
        print('YES')
        break
else:
    print('NO')
