import sys
import math
import bisect

def solve():
    A = []
    for i in range(4):
        A.append(input())
    for i in range(4):
        for j in range(4):
            if i + 2 < 4:
                B = []
                B.append(A[i][j])
                B.append(A[i+1][j])
                B.append(A[i+2][j])
                if sorted(B) == sorted(['x', 'x', '.']):
                    return True
            if j + 2 < 4:
                B = []
                B.append(A[i][j])
                B.append(A[i][j+1])
                B.append(A[i][j+2])
                if sorted(B) == sorted(['x', 'x', '.']):
                    return True
            if i + 2 < 4 and j + 2 < 4:
                B = []
                B.append(A[i][j])
                B.append(A[i+1][j+1])
                B.append(A[i+2][j+2])
                if sorted(B) == sorted(['x', 'x', '.']):
                    return True
            if i + 2 < 4 and j - 2 >= 0:
                B = []
                B.append(A[i][j])
                B.append(A[i+1][j-1])
                B.append(A[i+2][j-2])
                if sorted(B) == sorted(['x', 'x', '.']):
                    return True
    return False

def main():
    if solve():
        print('YES')
    else:
        print('NO')

if __name__ == "__main__":
    main()
