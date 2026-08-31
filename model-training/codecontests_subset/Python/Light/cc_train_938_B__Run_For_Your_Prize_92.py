input()
A = map(int, input().split())
B = map(lambda x: min(abs(x - 1), abs(x - 1000000)), A)
print(max(B))
