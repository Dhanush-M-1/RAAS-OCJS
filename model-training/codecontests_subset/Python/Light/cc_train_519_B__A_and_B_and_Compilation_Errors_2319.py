

n = int(input())
data = [
    sorted(list(map(int, input().split()))),
    sorted(list(map(int, input().split()))) + [0],
    sorted(list(map(int, input().split()))) + [0, 0],
]
error_1 = None
error_2 = None

for a1, a2 in zip(data[0], data[1]):
    if a1 != a2:
        error_1 = a1
        break

for a1, a2 in zip(data[1], data[2]):
    if a1 != a2:
        error_2 = a1
        break

print(error_1)
print(error_2)



