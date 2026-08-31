line = [x for x in input().split()]

f1, f2 = line[0], line[1]

n = int(input())

for i in range(n):
    print(f1, f2)
    line = [x for x in input().split()]
    f3, f4 = line[0], line[1]
    if f1 == f3:
        f1 = f4
    else:
        f2 = f4
print(f1, f2)
