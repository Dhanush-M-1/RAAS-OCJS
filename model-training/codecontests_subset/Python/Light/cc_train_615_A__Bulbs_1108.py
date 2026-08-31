n, m = map(int, input().split())

s = set();
for i in range(n):
    arr = input().split()
    for j in range(int(arr[0])):
        s.add(int(arr[j + 1]))

print("YES" if len(s) == m else "NO")