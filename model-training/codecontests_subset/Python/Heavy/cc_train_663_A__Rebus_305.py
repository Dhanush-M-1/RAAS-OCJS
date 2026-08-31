data = input()
data = data.split()
data.reverse()
n = int(data[0])
data.reverse()
pos = 1
neg = 0
for x in data:
    if x == '-':
        neg += 1
    if x == '+':
        pos += 1

ans = pos - neg

if ans <= n:
    tmp = n - ans
    if tmp > pos * (n - 1):
        print('Impossible')
        exit(0)
    else:
        print('Possible')
        fin = ''
        for x in range(len(data)):
            if data[x] != '?':
                fin += data[x] + ' '
                continue
            if x == 0 or data[x - 1] == '+':
                t = min(n - 1, tmp)
                tmp -= t
                fin += str(1 + t) + ' '
            else:
                fin += '1 '
        print(fin)
else:
    tmp = ans - n
    if tmp > neg * (n - 1):
        print('Impossible')
        exit(0)
    else:
        print('Possible')
        fin = ''
        for x in range(len(data)):
            if data[x] != '?':
                fin += data[x] + ' '
                continue
            if x != 0 and data[x - 1] == '-':
                t = min(n - 1, tmp)
                tmp -= t
                fin += str(1 + t) + ' '
            else:
                fin += '1 '
        print(fin)
