import sys
import math
import bisect

def main():
    for _ in range(int(input())):
        n = int(input())
        A = list(map(int, input().split()))
        B = []
        for i in range(n):
            if A[i] == -1:
                if i - 1 >= 0 and A[i-1] != -1:
                    B.append(A[i-1])
                if i + 1 < n and A[i+1] != -1:
                    B.append(A[i+1])
        B.sort()
        if len(B) == 0:
            k = 0
        else:
            min_val = min(B)
            max_val = max(B)
            k = (min_val + max_val) // 2
        for i in range(n):
            if A[i] == -1:
                A[i] = k
        max_delta = 0
        for i in range(n - 1):
            delta = abs(A[i+1] - A[i])
            max_delta = max(max_delta, delta)
        print('%d %d' % (max_delta, k))

if __name__ == "__main__":
    main()
