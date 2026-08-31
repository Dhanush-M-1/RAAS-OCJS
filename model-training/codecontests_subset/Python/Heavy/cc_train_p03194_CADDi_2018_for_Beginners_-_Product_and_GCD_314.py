n, p = map(int, input().split())

pp = p
# 2のべき乗チェック
count_2 = 0
while True:
    if pp % 2 == 0:
        pp = pp / 2
        count_2 += 1
    else:
        break


result = 2 ** (count_2 // n)

p = p / (2 ** count_2)

kisu = True if p / 2 != 0 else False

num2 = int(p ** (1/n)) + 1
if kisu:
    num2 = num2 - 1 if num2 % 2 == 0 else num2
else:
    num2 = num2 - 1 if num2 % 2 != 0 else num2


for i in range(num2, 1, -2):
    if p % (i ** n) == 0:
        print(result * i)
        break

else:
    print(result * 1)