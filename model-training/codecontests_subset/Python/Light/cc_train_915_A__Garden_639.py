n, k = map(int, input().split())
max_ = 0
a = list(map(int, input().split()))
for i in a:
    max_ = max(max_, i) if not k % i else max_
print(int(k/max_))
