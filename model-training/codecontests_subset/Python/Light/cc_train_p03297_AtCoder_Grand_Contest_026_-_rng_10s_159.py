def gcd(a, b):
    a, b = max(a, b), min(a, b)
    if b == 0:
        return a
    return gcd(b, a % b)

def check(A, B, C, D):
    if A < B:
        return False
    if C < A % B:
        return False
    if D < B:
        return False
    x = gcd(B, D)
    return B <= C + x

def main():
    T = int(input())
    for _ in range(T):
        A, B, C, D = map(int, input().split())
        if check(A, B, C, D):
            print("Yes")
        else:
            print("No")


if __name__ == "__main__":
    main()
