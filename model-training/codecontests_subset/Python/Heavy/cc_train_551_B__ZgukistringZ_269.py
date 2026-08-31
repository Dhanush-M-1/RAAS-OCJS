INF = 999999999999999999999999999999999999999

a = input()
b = input()
c = input()

a_letters = [0] * 26
b_letters = [0] * 26
c_letters = [0] * 26

for code in range(ord('a'), ord('z') + 1):
    letter = chr(code)
    a_letters[code - ord('a')] = a.count(letter)
    b_letters[code - ord('a')] = b.count(letter)
    c_letters[code - ord('a')] = c.count(letter)

while True:
    b_count = [0] * 26
    for i in range(26):
        if b_letters[i] > 0:
            b_count[i] = a_letters[i] // b_letters[i]
        else:
            b_count[i] = INF

    c_count = [0] * 26
    for i in range(26):
        if c_letters[i] > 0:
            c_count[i] = a_letters[i] // c_letters[i]
        else:
            c_count[i] = INF

    b_min = min(b_count)
    c_min = min(c_count)

    if b_min == 0 and c_min == 0:
        break

    if b_min > c_min:
        print(b, end='')
        for i in range(26):
            a_letters[i] -= b_letters[i]
    else:
        print(c, end='')
        for i in range(26):
            a_letters[i] -= c_letters[i]

for i in range(26):
    print(chr(ord('a') + i) * a_letters[i], end='')
print()
