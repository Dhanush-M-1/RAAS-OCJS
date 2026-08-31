n = int(input())
first = sorted(input().split())
second = sorted(input().split())
third = sorted(input().split())

for i in range(n - 1):
    if first[i] != second[i]:
        print(first[i])
        break
else:
    print(first[-1])

for i in range(n - 2):
    if second[i] != third[i]:
        print(second[i])
        break
else:
    print(second[-1])