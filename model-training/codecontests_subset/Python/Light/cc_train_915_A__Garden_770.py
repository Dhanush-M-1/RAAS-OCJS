f = lambda: map(int, input().split())
n, k = f()
print(k // max(a for a in f() if not k % a))