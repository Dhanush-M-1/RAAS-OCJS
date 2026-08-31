n, k = map(int, input().split())
print(k // max(ai for ai in map(int, input().split()) if k % ai == 0))