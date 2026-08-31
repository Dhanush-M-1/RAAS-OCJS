n = int(input())
a = (list(map(int, input().split())))
b = (list(map(int, input().split())))
c = (list(map(int, input().split())))
x = sum(a) - sum(b)
y = sum(b) - sum(c)

print(x, y, sep='\n')