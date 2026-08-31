def solve(A):
    res = 0
    right = len(A)
    while right != 0:
        for left in range(0, right):
            if left + 1 < len(A) and A[left] > A[left + 1]:
                A[left], A[left + 1] = A[left + 1], A[left]
                res += 1
        right -= 1
    return res

while True:
    n = int(input())
    if n == 0 : break
    A = [int(input()) for i in range(n)]
    print(solve(A))
