s = input().split()
n = int(s[-1])
summands = [1]
for sign in s[1::2]:
    if sign == '+':
        summands.append(1)
    elif sign == '-':
        summands.append(-n)
m = len(summands)
cur = sum(summands)
if cur > n:
    print('Impossible')
else:
    for i in range(m):
        summands[i] = n if summands[i] == 1 else -1
        cur += n - 1
        if cur >= n:
            summands[i] -= cur - n
            print('Possible')
            print(summands[0], end = '')
            for summand in summands[1:]:
                if summand < 0:
                    print(' - {0}'.format(-summand), end = '')
                else:
                    print(' + {0}'.format(summand), end = '')
            print(' = {0}'.format(n), end = '')
            break
    else:
        print('Impossible')
