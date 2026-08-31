n = int(input())
# n, k = map(int, input().split())
# a = [int(i) for i in input().split()]
d = [0 for i in range(n + 1)]
for i in range(n - 1):
    a, b = map(int, input().split())
    d[a] += 1; d[b] += 1
for val in d:
    if val == 2:
        print("NO")
        exit()
print("YES")
