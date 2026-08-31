N = int(input())

c = ['a' for _ in range(N)]
def f(i, k):
    if i == N:
        print(''.join(c))
        return
    for j in range(k + 1):
        c[i] = chr(ord('a') + j)
        f(i + 1, max(j + 1, k))

f(0, 0)

