def judge(n, words, password):
    anyEndWith0 = anyStartWith1 = False
    for i in range(n):
        if words[i] == password:
            return True
        if words[i][0] == password[1]:
            anyStartWith1 = True
        if words[i][1] == password[0]:
            anyEndWith0 = True
    if anyEndWith0 and anyStartWith1:
        return True
    return False
password = input()
n = int(input())
words = [input() for _ in range(n)]
print('YES' if judge(n, words, password) else 'NO')
