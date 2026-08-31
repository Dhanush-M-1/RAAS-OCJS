n = int(input())
list1 = []
count = 0

for i in range(n):
    h, a = (map(int, input().split()))
    list1.append([h, a])

for i in range(n):
    for j in range(n - i):
        if (list1[i][0] == list1[j+i][1] and
                list1[i][1] == list1[j+i][0]):
            count += 2
        if ((list1[i][0] == list1[j+i][1] and
                list1[i][1] != list1[j+i][0]) or
                (list1[i][0] != list1[j+i][1] and
                    list1[i][1] == list1[j+i][0])):
            count += 1

print(count)