n = int(input())
first = sorted(list(map(int, input().split())))
second = sorted(list(map(int, input().split())))
third = sorted(list(map(int, input().split())))

for one, two in zip(first, second):
    if one != two:
        print(one, end=' ')
        break
else:
    print(first[-1])

for one, two in zip(second, third):
    if one != two:
        print(one)
        break
else:
    print(second[-1])


