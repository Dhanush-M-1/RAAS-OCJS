# Задача №1 - B. A и B и ошибки компиляции

# n = int(input())
# m = map(int, input().split())
# m1 =
# del m[n - 1]
# m2 =
# del m[n - 2]
# print(m1)
# print(m2)

n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))
x1 = sum(a) - sum(b)
x2 = sum(b) - sum(c)
print(x1, x2, sep='\n')