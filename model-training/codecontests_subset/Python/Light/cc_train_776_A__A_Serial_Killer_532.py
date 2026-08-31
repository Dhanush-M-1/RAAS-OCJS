day = [str(i) for i in input().split()]
n = int(input())
result = []
result.append(day.copy())
while n > 0:
    kill = [str(i) for i in input().split()]
    if kill[0] == day[0]:
        day[0] = kill[1]
    else:
        day[1] = kill[1]
    result.append(day.copy())
    n -= 1

for i in result:
    print(i[0], i[1])