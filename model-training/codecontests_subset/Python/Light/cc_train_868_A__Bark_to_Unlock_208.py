def find_first(s, strs, n):
    for i in range(n):
        if strs[i][0] == s:
            return True
    return False

def find_last(s, strs, n):
    for i in range(n):
        if str[i][len(strs[i]) - 1] == s:
            return True
    return False

def check(password, strs, n):
    for i in range(n):
        if strs[i] == password:
            return True
    return False

password = input()
n = int(input())

str = [0] * 105
for i in range(n):
    str[i] = input()

if find_first(password[1], str, n) and find_last(password[0], str, n) or check(password, str, n):
    print('YES')
else:
    print('NO')
