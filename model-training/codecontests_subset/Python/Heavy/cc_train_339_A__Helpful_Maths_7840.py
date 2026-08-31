s = input()
numbers = [0, 0, 0]
for c in s:
    if c == '1':
        numbers[0] += 1
    elif c == '2':
        numbers[1] += 1
    elif c == '3':
        numbers[2] += 1
ones = '+'.join('1' for _ in range(numbers[0]))
twos = '+'.join('2' for _ in range(numbers[1]))
threes = '+'.join('3' for _ in range(numbers[2]))

word = ones
if word and twos:
    word = word + '+' + twos
elif not word and twos:
    word = twos
if word and threes:
    word = word + '+' + threes
elif not word and threes:
    word = threes
print(word)