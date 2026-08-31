# Aizu Problem 00167: Bubble Sort
#
import sys, math, os, bisect

# read input:
PYDEV = os.environ.get('PYDEV')
if PYDEV=="True":
    sys.stdin = open("sample-input.txt", "rt")


def bubble_sort(N, A):
    cnt = 0
    last = N - 1
    while last > 0:
        for k in range(last):
            if A[k] > A[k+1]:
                A[k], A[k+1] = A[k+1], A[k]
                cnt += 1
        last -= 1
    return cnt


while True:
    N = int(input())
    if N == 0:
        break
    A = [int(input()) for _ in range(N)]
    print(bubble_sort(N, A))
 