pswd = input()
w = [input() for _ in range(int(input()))]

if pswd[1] in [x[0] for x in w] and pswd[0] in [x[1] for x in w] or pswd in w:
    print('YES')
else:
    print('NO')
