names = set(input().split())
n = int(input())
for i in range(n):
    print(*names)
    f, s = input().split()
    if f in names:
        names.remove(f)
        names.add(s)
    else:
        names.remove(s)
        names.add(f)

print(*names)
