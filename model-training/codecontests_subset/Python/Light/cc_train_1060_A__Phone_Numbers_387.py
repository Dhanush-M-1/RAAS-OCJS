n = int(input()) // 11
count_8 = 0
for i in input():
    count_8 += 1 if i == '8' else 0
print(min(n, count_8))
