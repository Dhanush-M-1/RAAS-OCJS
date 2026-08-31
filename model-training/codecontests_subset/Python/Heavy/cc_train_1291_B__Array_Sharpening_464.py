def main():
    t = int(input().strip())
    for _ in range(t):
        n = int(input().strip())
        A = [int(s) for s in input().strip().split()]
        if n % 2 == 1:
            result = all(a >= min(i, n - 1 - i) for i, a in enumerate(A))
        else:
            B1 = list(range(n // 2 + 1)) + list(range(n // 2 - 2, -1, -1))
            B2 = B1[::-1]
            result = all(a >= b for a, b in zip(A, B1)) or all(a >= b for a, b in zip(A, B2))
        print("Yes" if result else "No")


main()
