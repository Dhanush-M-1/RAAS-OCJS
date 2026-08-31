n = int(input())
x1 = sum(list(map(int, input().split())))
x2 = sum(list(map(int, input().split())))
x3 = sum(list(map(int, input().split())))

print(x1 - x2, x2 - x3, sep="\n")