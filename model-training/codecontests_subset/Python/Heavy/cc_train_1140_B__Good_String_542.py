t = int(input())
for j in range(t):
    n = int(input())
    string = input()

    lcounter = 0
    rcounter = 0
    changed = False

    for i in range(n):
        if string[i] == '<' and not changed:
            lcounter += 1
        if string[i] != '<':
            changed = True
            break

    changed = False

    string = string[::-1]
    for i in range(n):
        if string[i] == '>' and not changed:
            rcounter += 1
        if string[i] != '>':
            changed = True
            break

    print(min(lcounter, rcounter))