k = int(input())
word = input()
frequencies = dict()
exist_solution = True
for char in word:
    frequencies[char] = frequencies.get(char, 0) + 1

for char, frequency in frequencies.items():
    if frequency % k != 0:
        exist_solution = False
        break
    else:
        frequencies[char] = frequencies[char] // k

if not exist_solution:
    print(-1)
else:
    solution = list()
    for char, frequency in frequencies.items():
        solution.extend([char] * frequency)
    solution = solution * k
    print(''.join(solution))
