password = input()
n = int(input())
words = [input() for i in range(n)]
for i in words:
    for j in words:
        if password in i+j:
            print('YES')
            raise SystemExit
print('NO')