n, m = map(int, input().split())
first = []
second = []
common = []

array = []
for s in range(n):
    a, b, c = map(int, input().split())
    array.append([a, b, c])
f, s, d = 0, 0, 0
for i in range(n):
    a = array[i][0]
    b = array[i][1]
    c = array[i][2]
    if (b == 1 and c == 1):
        common.append(a)
        d += 1
    elif (b == 1 and c == 0):
        first.append(a)
        f += 1
    elif (b == 0 and c == 1):
        second.append(a)
        s += 1
mini = min(f, s)
first.sort()
second.sort()
for i in range(mini):
    common.append(first[i] + second[i])
common.sort()
add = 0
if (m <= d + mini):

    for i in range(m):
        add += common[i]
    print(add)
else:
    print(-1)