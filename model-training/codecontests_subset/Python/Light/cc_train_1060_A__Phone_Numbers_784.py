length = int(input())
s = input()
max_num = int(length / 11)
eight_num = 0
for i in range(length):
    if s[i] == '8':
        eight_num += 1
if eight_num >= max_num:
    print(max_num)
else:
    print(eight_num)
