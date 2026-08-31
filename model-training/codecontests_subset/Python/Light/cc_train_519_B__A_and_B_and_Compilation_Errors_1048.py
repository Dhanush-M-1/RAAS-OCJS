R = lambda: map(int, input().split())
o = int(input())
v1 = list(R())
v2 = list(R())
v3 = list(R())
d = {}

print(sum(v1) - sum(v2))
print(sum(v2) - sum(v3))