st = input()
dct = [input() for i in range(int(input()))]

first = [i[0] for i in dct]
last = [i[1] for i in dct]

print('YES') if st in dct or st[0] in last and st[1] in first else print('NO')
