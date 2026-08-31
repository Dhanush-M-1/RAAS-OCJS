_ = input()
list_1st, list_2nd, list_3rd = sorted(map(int, input().strip().split(' '))), sorted(map(int, input().strip().split(' '))), sorted(map(int, input().strip().split(' ')))
for x in range(len(list_1st)-1):
    if list_1st[x] != list_2nd[x]:
        print(list_1st[x])
        break
    if x == len(list_1st)-2:
        print(list_1st[-1])
for x in range(len(list_2nd)-1):
    if list_2nd[x] != list_3rd[x]:
        print(list_2nd[x])
        break
    if x == len(list_2nd)-2:
        print(list_2nd[-1])