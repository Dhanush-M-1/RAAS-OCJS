'''
# Театральная площадь
import math
n, m, a = map(int, input().split())
bb = math.ceil(n/a)
b = math.ceil(m/a)
print(bb* b)
# Укладка доминошками
m, n = map(int, input().split())
pl = n*m
print(pl//2)
# Bit++
x = 0
n = int(input())
while n > 0:
    a = input()
    if a == '--X' or a == 'X--':
        x -= 1
    elif a == '++X' or a == 'X++':
        x += 1
    n -= 1
print(x)
# Неправильное вычитание
n, k = map(int, input().split())
while k > 0:
    end = n % 10
    if end != 0:
        n -= 1
    elif end == 0:
        n //= 10
    k -= 1
print(n)
# Чет и нечет
n, k = map(int, input().split())
x = n //2 + n% 2
if k <= x:
    print(2*k-1)
elif k > x:
    print(2*(k-x))
# Восстановление трех чисел
x = list(map(int, input().split()))
maxx = max(x) #произведение
x.sort()
print(maxx-x[0], maxx-x[1], maxx-x[2])
# Про награды
a1, a2, a3 = map(int, input().split())
b1, b2, b3 = map(int, input().split())
n = int(input())
a = a1+ a2+ a3
b = b1+ b2+ b3
polka1 = 0
polka2 = 0
if a % 5==0:
    polka1 = a//5
else:
    polka1 = a//5+1
if b%10 ==0:
    polka2 = b//10
else:
    polka2 = b//10+1
if polka1+polka2 <= n:
    print('YES')
else:
    print('NO')
'''
# Опять двадцать пять!
n = int(input())
print(25)

