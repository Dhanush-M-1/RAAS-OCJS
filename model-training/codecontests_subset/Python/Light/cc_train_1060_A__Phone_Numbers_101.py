n = int(input())
chars = input()

chars_map = [0] * 10
for char in chars:
    chars_map[ord(char)-ord('0')] += 1

numbers_count = 0

while chars_map[8]:
    chars_map[8] -= 1
    remaining = 10
    for char in [0, 1, 2, 3, 4, 5, 6, 7, 9, 8]:
        diff = min(remaining, chars_map[char])
        remaining -= diff
        chars_map[char] -= diff
        if remaining == 0:
            break
    if remaining == 0:
        numbers_count += 1
    else:
        break

print(numbers_count)
