n = int(input())
digits = input()

num_eights = sum(1 for x in digits if x == '8')
num_not_eights = len(digits) - num_eights

num_phones = None
while True:
    num_phones = min(num_eights, num_not_eights // 10)
    if num_eights > num_phones:
        num_eights -= 1
        num_not_eights += 1
    else:
        break

print(num_phones)
