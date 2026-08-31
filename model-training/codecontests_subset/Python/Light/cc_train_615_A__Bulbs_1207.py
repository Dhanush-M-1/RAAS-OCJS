n, m = input().split()
n, m = int(n), int(m)
on = set()

for _ in range(n):
    head, *tail = input().split()
    on.update(map(int, tail))

for i in range(1, m+1):
    if i not in on:
        print("NO")
        break
else:
    print("YES")