Read = lambda: list(map(int, input().split()))
n, k = Read()
print(k // max(x for x in Read() if k % x == 0))