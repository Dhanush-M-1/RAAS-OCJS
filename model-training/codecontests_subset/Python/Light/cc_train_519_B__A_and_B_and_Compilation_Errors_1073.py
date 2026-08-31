n = int(input())
first = sorted([int(x) for x in input().split()])
second = sorted([int(x) for x in input().split()])
third = sorted([int(x) for x in input().split()])
for i in range(len(second)):
	del(first[first.index(second[i])])
print(first[0])
for i in range(len(third)):
	del(second[second.index(third[i])])
print(second[0])