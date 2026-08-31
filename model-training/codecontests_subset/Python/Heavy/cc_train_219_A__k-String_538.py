k = int(input())

s = input()
s = list(s)
s.sort()

answer = []
div = int(len(s) / k)
previous_char = ''
letter_frequency = 0
for c in s:
    if previous_char == '':
        previous_char = c
        letter_frequency += 1
    elif previous_char != c:
        answer.append({'char': previous_char, 'frequency': letter_frequency})
        previous_char = c
        letter_frequency = 1
    else:
        letter_frequency += 1
answer.append({'char': previous_char, 'frequency': letter_frequency})

repeated_string = ''
for ans in answer:
    if ans['frequency'] % k != 0:
        print(-1)
        exit(0)
    for i in range(int(ans['frequency'] / k)):
       repeated_string += ans['char']

result = ''
for i in range(k):
    result += repeated_string
print(result)
