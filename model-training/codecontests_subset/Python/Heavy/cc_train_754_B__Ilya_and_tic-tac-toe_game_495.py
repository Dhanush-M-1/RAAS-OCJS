m = []
m.append("######")
m.append("######")
m+=[input()+"##" for i in range(4)]
m.append("######")
m.append("######")
cool = ["xx.", "x.x", ".xx"]
for i in range (2, 6):
    for j in range(0, 4):
        if  (m[i][j] + m[i][j + 1]+ m[i][j+2]) in cool or\
            (m[i][j] + m[i +1][j] + m[i + 2][j]) in cool or\
            (m[i][j] + m[i + 1][j + 1] + m[i + 2][j + 2]) in cool or\
            (m[i][j] + m[i - 1][j + 1] + m[i - 2][j + 2]) in cool:
            print("YES")
            exit()

print("NO")