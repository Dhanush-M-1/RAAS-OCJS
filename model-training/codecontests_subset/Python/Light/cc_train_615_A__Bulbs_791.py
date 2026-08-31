string = input()
numbers = string.split(" ")
a = int(numbers[0])
b = int(numbers[1])
bulbs = []
for x in range(a):
    string = input()
    numbers = string.split(" ")
    n = int(numbers[0])
    for y in range(1, n + 1):
        bulbs.append(int(numbers[y]))
results = "YES"
for x in range(1, b + 1):
    if not x in bulbs:
        results = "NO"
        break
print(results)