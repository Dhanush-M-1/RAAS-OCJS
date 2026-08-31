n = int(input())
a = list(map(int, input().split()))
b = []
for i in range(n):
    b.append(min(a[i] - 1, abs(int(a[i] - 10e5))))
print(max(b))