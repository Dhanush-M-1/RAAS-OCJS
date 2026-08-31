s1 = input()
n = int(input())
s = [input() for i in range(n)]
for i in s:
    for j in s:
        if s1 in i + j:
            print('YES')
            exit()
print('NO')