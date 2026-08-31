def b(n, k):
    v = ''
    while n:
        n, v = n // k, str(n % k) + v
    return v
k = int(input())
for i in range(1, k):
    print(' '.join(b(i * j, k) for j in range(1, k)))