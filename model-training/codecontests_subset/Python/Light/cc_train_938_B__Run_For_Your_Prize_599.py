n = int(input())
l = [*map(int, input().split())]
res = [min(e - 1, int(1e6) - e) for e in l]
print(max(res))