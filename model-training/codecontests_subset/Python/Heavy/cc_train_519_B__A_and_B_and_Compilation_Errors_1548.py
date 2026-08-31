n = int(input())
first = [int(i) for i in input().split(" ")]
second = [int(i) for i in input().split(" ")]
third = [int(i) for i in input().split(" ")]

First = {}
for i in first:
    if i in First:
        First[i] += 1
    else:
        First[i] = 1
Second = {}
for i in second:
    if i in Second:
        Second[i] += 1
    else:
        Second[i] = 1

Third = {}
for i in third:
    if i in Third:
        Third[i] += 1
    else:
        Third[i] = 1
ans = []
for i in first:
    if i not in Second or First[i] != Second[i]:
        print(i)
        break

for i in second:
    if i not in Third or Third[i] != Second[i]:
        print(i)
        break

