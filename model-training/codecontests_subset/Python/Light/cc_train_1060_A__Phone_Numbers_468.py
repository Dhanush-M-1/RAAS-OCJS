n = input()
numbers = input()
eights = 0
max_nums = len(numbers)//11
for n in numbers:
    if n == '8':
        eights += 1
if eights >= max_nums:
    print(max_nums)
else:
    print(eights)
