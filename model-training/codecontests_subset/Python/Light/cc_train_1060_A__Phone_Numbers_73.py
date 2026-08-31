n = int(input())
s = list(input())
cnt_8 = 0
for item in s:
    if item == '8':
        cnt_8 += 1
cnt_num = n//11
if cnt_8 > cnt_num:
    print(cnt_num)
else:
    print(cnt_8)
