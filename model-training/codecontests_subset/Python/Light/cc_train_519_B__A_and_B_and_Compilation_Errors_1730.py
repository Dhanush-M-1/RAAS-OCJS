n = int(input())
a = [[]]
for i in range(3):
    a.insert(i, [int(x) for x in input().split()])
print(sum(a[0])-sum(a[1]))
print(sum(a[1])-sum(a[2]))
