namez = input().split()
n = int(input())
for i in range(n):
    print(' '.join(namez))
    name1, name2 = input().split()
    namez[namez.index(name1)] = name2
print(' '.join(namez))
