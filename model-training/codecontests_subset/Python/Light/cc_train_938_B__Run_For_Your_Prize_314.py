n = int(input())
s = [1] + list(map(int, input().split())) + [1000000]
x = set()
for i in range(n + 1):
    x.add(max(s[i] - 1, 1000000 - s[i + 1]))
print(min(x))
