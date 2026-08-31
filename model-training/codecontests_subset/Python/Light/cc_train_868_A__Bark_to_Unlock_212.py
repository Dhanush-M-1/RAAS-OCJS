if __name__ == '__main__':
    password = input()
    n = int(input())
    words = list()
    for i in range(n):
        words.append(input())
    first_word = [words[i][0] for i in range(n)]
    second_word = [words[i][1] for i in range(n)]
    if password in words:
        print('YES')
    elif password[1] in first_word and password[0] in second_word:
        print('YES')
    else:
        print('NO')