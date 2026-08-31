count1, count2 = 0, 0
password = input()
n = int(input())
for i in range(n):
    podstr = input()
    if podstr == password or (podstr[0]==password[1] and podstr[1]==password[0]):
        print('YES')
        exit()
    elif podstr[1] == password[0]:
        count1=1
    elif podstr[0] == password[1]:
        count2=1
if count1 + count2 >= 2:
    print('YES')
else:
    print('NO')
