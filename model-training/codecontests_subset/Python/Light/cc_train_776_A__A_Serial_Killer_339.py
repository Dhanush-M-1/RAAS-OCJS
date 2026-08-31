data = set()
for el in input().split():
    data.add(el)
n = int(input())
for i in range(n):
    print(" ".join(data))
    a, b = input().split()
    data.remove(a)
    data.add(b)
print(" ".join(data))
