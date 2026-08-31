n, l = map(int, input().split())
a = list(map(int, input().split()))
mini = l + 1
for i in range(n):
    if a[i] > l:
        continue
    k = l // a[i]
    if l % a[i] == 0 and k < mini and k != 0:
        mini = k
        ans = a[i]
print(mini)