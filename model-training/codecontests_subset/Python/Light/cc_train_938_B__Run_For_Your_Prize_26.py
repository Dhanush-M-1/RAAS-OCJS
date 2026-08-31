n = int(input())
list = input().split(' ')
for i in range(0, n):
    list[i] = int(list[i])
dist = []
for el in list:
    dist.append(abs(500000.5 - el))

print(int(500000.5-min(dist)-1))