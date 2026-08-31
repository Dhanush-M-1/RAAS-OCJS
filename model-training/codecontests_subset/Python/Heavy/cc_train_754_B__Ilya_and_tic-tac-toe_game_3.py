import sys, copy
A = []

def isAllX(a1, a2, b1, b2, c1, c2):
    global A
    if A[a1][a2] == "x" and A[b1][b2] == "x" and A[c1][c2] == "x":
        return True
    return False


for i in range(4):
    s = input()
    B = []
    for i in s:
        B.append(i)
    A.append(B)

for i in range(4):
    for j in range(4):
        if A[i][j] == ".":
            C = copy.deepcopy(A)
            A[i][j] = "x"
            if isAllX(0, 0, 0, 1, 0, 2) or isAllX(0, 1, 0, 2, 0, 3)\
            or isAllX(1, 0, 1, 1, 1, 2)\
            or isAllX(1, 1, 1, 2, 1, 3)\
            or isAllX(2, 0, 2, 1, 2, 2)\
            or isAllX(2, 1, 2, 2, 2, 3)\
            or isAllX(3, 0, 3, 1, 3, 2)\
            or isAllX(3, 1, 3, 2, 3, 3)\
            or isAllX(0, 0, 1, 0, 2, 0)\
            or isAllX(1, 0, 2, 0, 3, 0)\
            or isAllX(0, 1, 1, 1, 2, 1)\
            or isAllX(1, 1, 2, 1, 3, 1)\
            or isAllX(0, 2, 1, 2, 2, 2)\
            or isAllX(1, 2, 2, 2, 3, 2)\
            or isAllX(0, 3, 1, 3, 2, 3)\
            or isAllX(1, 3, 2, 3, 3, 3)\
            or isAllX(0, 0, 1, 1, 2, 2)\
            or isAllX(1, 1, 2, 2, 3, 3)\
            or isAllX(1, 0, 2, 1, 3, 2)\
            or isAllX(0, 1, 1, 2, 2, 3)\
            or isAllX(0, 3, 1, 2, 2, 1)\
            or isAllX(1, 2, 2, 1, 3, 0)\
            or isAllX(0, 2, 1, 1, 2, 0)\
            or isAllX(1, 3, 2, 2, 3, 1):
                print("YES")
                sys.exit()
            A = copy.deepcopy(C)
print("NO")
