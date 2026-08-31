def is_prime(x):
    for j in range(2, int(x ** 0.5) + 1):
        if x % j == 0:
            return False
    else:
        return True


n, k = map(int, input().split())
a = list(map(int, input().split()))
mn = []
if is_prime(k):
    exit(print(k if k not in a else 1))
else:
    for i in range(n):
        if k % a[i] == 0:
            mn.append(k // a[i])
print(min(mn))