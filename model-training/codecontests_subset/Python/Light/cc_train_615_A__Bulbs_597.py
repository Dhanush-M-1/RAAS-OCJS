n, m = map(int, input().split())
mass = []
for i in range(n):
    tmp_list = list(map(int, input().split()))
    mass += tmp_list[1:]

flag = True
for i in range(1, m+1):
    if i not in mass:
        flag = False
print('YES') if flag else print('NO')
