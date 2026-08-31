gor1 = input()
gor2 = input()
gor3 = input()
gor4 = input()

vert1 = gor1[0] + gor2[0] + gor3[0] + gor4[0]
vert2 = gor1[1] + gor2[1] + gor3[1] + gor4[1]
vert3 = gor1[2] + gor2[2] + gor3[2] + gor4[2]
vert4 = gor1[3] + gor2[3] + gor3[3] + gor4[3]

diag1 = gor1[0] + gor2[1] + gor3[2] + gor4[3]
diag2 = gor1[3] + gor2[2] + gor3[1] + gor4[0]
diag3 = gor1[1] + gor2[2] + gor3[3]
diag4 = gor2[0] + gor3[1] + gor4[2]
diag5 = gor1[2] + gor2[1] + gor3[0]
diag6 = gor2[3] + gor3[2] + gor4[1]

if "xx." in gor1 or "xx." in gor2 or "xx." in gor3 or "xx." in gor4 or ".xx" in gor1 or ".xx" in gor2 or ".xx" in gor3 or ".xx" in gor4 or "x.x" in gor1 or "x.x" in gor2 or "x.x" in gor3 or "x.x" in gor4:
    print("YES")
elif "xx." in vert1 or "xx." in vert2 or "xx." in vert3 or "xx." in vert4 or ".xx" in vert1 or ".xx" in vert2 or ".xx" in vert3 or ".xx" in vert4 or "x.x" in vert1 or "x.x" in vert2 or "x.x" in vert3 or "x.x" in vert4:
    print("YES")
elif "xx." in diag1 or "xx." in diag2 or "xx." in diag3 or "xx." in diag4 or "xx." in diag5 or "xx." in diag6 or ".xx" in diag1 or ".xx" in diag2 or ".xx" in diag3 or ".xx" in diag4 or ".xx" in diag5 or ".xx" in diag6 or "x.x" in diag1 or "x.x" in diag2 or "x.x" in diag3 or "x.x" in diag4 or "x.x" in diag5 or "x.x" in diag6:
    print("YES")
else:
    print("NO")