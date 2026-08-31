from collections import Counter

total_numbers = int(input())
counter_one = Counter()

a = None
b = None
for i in map(int, input().split()):
    if i not in counter_one:
        counter_one[i] = 1
    else:
        counter_one[i] += 1

counter_two = Counter()

for i in map(int, input().split()):
    if i not in counter_two:
        counter_two[i] = 1
    else:
        counter_two[i] += 1

for v in counter_one:
    if v not in counter_two:
        a = v
        break
    else:
        if counter_one[v] - counter_two[v] == 1:
            a = v
            break

counter_three = Counter()

for i in map(int, input().split()):
    if i not in counter_three:
        counter_three[i] = 1
    else:
        counter_three[i] += 1


for v in counter_two:
    if v not in counter_three:
        b = v
        break
    else:
        if counter_two[v] - counter_three[v] == 1:
            b = v
            break

print(a)
print(b)