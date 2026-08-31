name1, name2 = input().lower().split(' ')
print(name1+" "+name2)
n = int(input())
i = 0
while i < n:
    victim1, victim2 = input().lower().split(' ')
    if name1 == victim1:
        name1 = victim2
    elif name2 == victim1:
        name2 = victim2
    print(name1+" "+name2)
    i+=1
# ross rachel
# 4
# ross joey
# rachel phoebe
# phoebe monica
# monica chandler

# icm codeforces
# 1
# codeforces technex
