import sys
digits = int(input())

num = input()
total = 0
for i in range(len(num)):
    if total == digits//11:
        print(total)
        sys.exit()

    if num[i] == '8':
        total += 1
        continue

print(total)