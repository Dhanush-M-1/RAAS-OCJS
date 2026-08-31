names = input().split()
print(*names)
n = int(input())
for i in range(0, n, 1):
    values = input().split()
    names.remove(values[0])
    names.insert(0, values[1])
    print(*names)
