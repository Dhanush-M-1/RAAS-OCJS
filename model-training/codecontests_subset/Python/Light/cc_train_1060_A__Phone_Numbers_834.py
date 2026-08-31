n = int(input())
s = input()

digits = [0]*10
for digit in s:
    num = int(digit)
    digits[num] += 1

res = 0
while digits[8] != 0:
    s = "8"
    digits[8] -= 1

    i = 0
    while (i < 10) and (len(s) < 11):
        while (digits[i] > 0) and (len(s) < 11):
            digits[i] -= 1
            s += str(i)

        i += 1
        i = 9 if i == 8 else i

    i = 8
    while (digits[i] > 0) and (len(s) < 11):
        digits[i] -= 1
        s += str(i)

    if len(s) == 11:
        res += 1

print(res)