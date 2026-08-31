for _ in range(int(input())):
    n, m = map(int, input().split())
    s = input()
    p = sorted(list(map(int, input().split())) + [0] + [n], reverse=True)
    alphabet = {'a': 0, 'b': 0, 'c': 0, 'd': 0, 'e': 0, 'f': 0, 'g': 0, 'h': 0, 'i': 0, 'j': 0, 'k': 0, 'l': 0, 'm': 0, 'n': 0, 'o': 0, 'p': 0, 'q': 0, 'r': 0, 's': 0, 't': 0, 'u': 0, 'v': 0, 'w': 0, 'x': 0, 'y': 0, 'z': 0}
    c = 1
    for i in range(m+1):
        if p[i] != 0:
            for j in s[p[i+1]:p[i]]:
                alphabet[j] += c
            c += 1
    for i in alphabet.values():
        print(i, end=' ')
    print()