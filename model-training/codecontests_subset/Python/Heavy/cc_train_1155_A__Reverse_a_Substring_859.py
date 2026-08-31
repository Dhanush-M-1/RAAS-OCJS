if __name__ == '__main__':
    input()
    s = input()
    srt = ''.join(sorted(s))

    if s == srt:
        print('NO')
    else:
        print('YES')
        first = 0
        second = 0
        symbol = 0

        for i, (a, b) in enumerate(zip(s, srt)):
            if a != b:
                first = i
                symbol = b
                break
        for i in range(first, len(s)):
            if s[i] == b:
                second = i
        print(' '.join(map(str, (first + 1, second + 1))))