n = int(input())
first = sorted(map(int, input().split()))
second = sorted(map(int, input().split()))
third = sorted(map(int, input().split()))
MAX = 10 ** 9 + 1

second.append(MAX)
third.extend([MAX, MAX])
for i, j in zip(first, second):
    if i != j:
        print(i)
        break

for i, j in zip(second, third):
    if i != j:
        print(i)
        break
