n, m = map(int, input().split())
print(min([m//k for k in map(int, input().split()) if m % k == 0]))