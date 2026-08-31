n =int(input())

prizes = list(map(int, input().split()))[:n]
print(max([min (p, 1000001 - p) for p in prizes]) - 1)
