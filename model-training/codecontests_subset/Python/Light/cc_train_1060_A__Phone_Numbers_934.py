n = int(input())
num = input()
# print(num)

if '8' not in num:
    print(0)
else:
    print(min(num.count('8') , n//11))