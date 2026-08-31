t = int(input())

for _ in range(t):
    a, b, n = map(int, input().split())

    abin = list(format(a, '064b'))
    bbin = list(format(b, '064b'))

    if n==0:
        print(a)
        continue
    if n==1:
        print(b)
        continue

    # print(abin)
    # print(bbin)
    cbin = list()
    for i in range(64):
        if abin[i] == '0' and bbin[i] == '0':
            cbin.append('0')
        elif abin[i] == '1' and bbin[i] == '1':
            cbin.append(['1', '1', '0'][n%3])
        elif abin[i] == '1' and bbin[i] == '0':
            cbin.append(['1', '0', '1'][n%3])
        else: #01
            cbin.append(['0', '1', '1'][n%3])

    # print(''.join(abin))
    # print(''.join(bbin))
    # print(''.join(cbin))
    print(int(''.join(cbin), base=2))
        