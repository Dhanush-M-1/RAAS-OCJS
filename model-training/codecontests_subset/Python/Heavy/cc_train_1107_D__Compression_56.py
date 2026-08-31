import sys
import math


def compression(n, matrix):
    i = ans = 0
    while i < n:
        j = i + 1
        while j < n and matrix[i] == matrix[j]:
            j += 1
        ans = math.gcd(ans, j - i)
        col = 0
        while col < n:
            l = col + 1
            while l < n and matrix[i][col] == matrix[i][l]:
                l += 1
            ans = math.gcd(ans, col - l)
            col = l
        i = j
    return ans


if __name__ == "__main__":
    n = int(sys.stdin.readline())
    matrix = [[] for _ in range(n)]
    for i in range(n):
        matrix[i] = bin((1 << n) | int(sys.stdin.readline(), 16))[3:]
    print(compression(n, matrix))
