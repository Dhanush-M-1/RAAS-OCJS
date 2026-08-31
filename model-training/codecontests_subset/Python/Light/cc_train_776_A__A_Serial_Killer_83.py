names = input().split()
print(*names)
n = int(input())
for i in range(0, n, 1):
    first, last = input().split()
    names.remove(first)
    names.append(last)
    print(*names)
