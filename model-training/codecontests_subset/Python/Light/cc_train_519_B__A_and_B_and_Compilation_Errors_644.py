input()
a, b, c = [sum(map(int, input().split())) for i in ' '*3]
print(a - b)
print(b - c)