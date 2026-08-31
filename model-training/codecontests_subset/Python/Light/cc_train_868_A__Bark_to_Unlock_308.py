pw, words, first, second = input(), set(), set(), set()

for _ in range(int(input())):
    word = input()
    words.add(word)
    first.add(word[0])
    second.add(word[1])

print('YES' if pw in words or pw[0] in second and pw[1] in first else 'NO')