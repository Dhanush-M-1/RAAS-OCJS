r1, r2 = map(int, input().split(" "))
c1, c2 = map(int, input().split(" "))
d1, d2 = map(int, input().split(" "))
row1_list = list()
row2_list = list()
unlock_gems_of_r1 = list()
unlock_gems_of_r2 = list()
final_set = set()

for gem_no1 in range(1, 10):
    for gem_no2 in range(1, 10):
        if (gem_no1 + gem_no2) == r1:
            row1_list.append(gem_no1)
            row1_list.append(gem_no2)

        if (gem_no1 + gem_no2) == r2:
            row2_list.append(gem_no1)
            row2_list.append(gem_no2)


for i in range(0, int(len(row1_list)), 2):
    if len(unlock_gems_of_r1) > 0 or len(unlock_gems_of_r2) > 0:
        break
    for x in range(0, int(len(row2_list)), 2):
        if ((row1_list[i] + row2_list[x]) == c1 and (row1_list[i+1] + row2_list[x+1]) == c2) and ((row1_list[i] + row2_list[x+1]) == d1 and (row1_list[i+1] + row2_list[x]) == d2):
            unlock_gems_of_r1.append(row1_list[i])
            unlock_gems_of_r1.append(row1_list[i+1])
            unlock_gems_of_r2.append(row2_list[x])
            unlock_gems_of_r2.append(row2_list[x+1])
            final_set.add(row1_list[i])
            final_set.add(row1_list[i+1])
            final_set.add(row2_list[x])
            final_set.add(row2_list[x+1])
            break

if len(final_set) < 4:
    print(-1)
else:
    print(*unlock_gems_of_r1)
    print(*unlock_gems_of_r2)

# print("i: " + str(row1_list[i]), "i+1: " + str(row1_list[i+1]))
# print("x: " + str(row2_list[x]), "x+1: " + str(row2_list[x+1]))
