password = input()
n = int(input())
words = []
for i in range(n):
    words.append(input())
for word_i in words:
    for word_k in words:
        if password in word_i + word_k:
            print('YES')
            exit()
print('NO')