def solution():
    password = input()
    num_words = int(input())
    words = []
    for _ in range(num_words):
        words.append(input())

    for x in range(num_words):
        for y in range(num_words):
            possible = words[x] + words[y]
            if password in possible:
                print('YES')
                return
    print('NO')


solution()
