n     = int(input())
cards = list(map(int, list(input())))

max_num = len(cards) // 11

eights_counter = 0
for num in cards:
    if num == 8:
        eights_counter += 1

max_num = min(max_num, eights_counter)
print(max_num)