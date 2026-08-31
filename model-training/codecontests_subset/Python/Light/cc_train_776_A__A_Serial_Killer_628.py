dict = {}
for i in input().split():
    dict[i] = 1
for i in dict.keys():
    print(i, end = " ")
print()

n = int(input())
for i in range(n):
    x, y = input().split()
    del dict[x]
    dict[y] = 1
    for i in dict.keys():
        print(i, end = " ")
    print()
