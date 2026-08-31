n = int(input()) // 11
numbers = input()
count_8 = 0
for i in numbers:
    count_8 += 1 if i == '8' else 0
print(min(n, count_8))
