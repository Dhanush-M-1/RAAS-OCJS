n = int(input())

s = input()
num = 0

div = int(n/11)


for i in s:
    if i == '8':
        num = num +1
    if num == div:
        break



if num > 0 and div > 0:

    print(num)
else:
    print(0)
