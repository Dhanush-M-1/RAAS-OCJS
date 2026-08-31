# A и B и ошибки компиляции
n = int(input())
a = [int(x) for x in input().split()]
b = [int(x) for x in input().split()]
c = [int(x) for x in input().split()]
answer_1 = sum(a) - sum(b)
answer_2 = sum(b) - sum(c)
print(answer_1)
print(answer_2)