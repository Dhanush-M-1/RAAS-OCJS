n, k = map(int, input().split())
a = list(map(int, input().split()))
a.sort(reverse=True)
for i in a:
    if k%i == 0:
        n = k/i
        break

print(int(n))