expr = input()

q_cnt = expr.count('?')
plus_cnt = expr.count('+')
minus_cnt = expr.count('-')

n = int(expr[expr.find('= ') + 2:])

if plus_cnt + 1 > n * (minus_cnt + 1) or n * (plus_cnt + 1) < n + minus_cnt:
    print('Impossible')
else:
    tokens = expr.split()
    before = 's'
    output = [t for t in tokens]
    if plus_cnt == minus_cnt:
        for i, t in enumerate(tokens):
            if t == '?':
                if before == 's':
                    output[i] = str(n)
                else:
                    output[i] = str(1)
            else:
                before = t
    elif plus_cnt > minus_cnt:
        yobun = plus_cnt - minus_cnt
        for i, t in enumerate(tokens):
            if t == '?':
                if before == 's':
                    output[i] = str(max(1, n - yobun))
                    yobun -= n - int(output[i])
                elif before == '+':
                    output[i] = str(1)
                else:
                    output[i] = str(min(n, yobun + 1))
                    yobun -= int(output[i]) - 1
            elif t == '+' or t == '-':
                before = t
    else:
        yobun = minus_cnt - plus_cnt
        for i, t in enumerate(tokens):
            if t == '?':
                if before == 's':
                    output[i] = str(n)
                elif before == '+':
                    output[i] = str(min(n, yobun + 1))
                    yobun -= int(output[i]) - 1
                else:
                    output[i] = str(1)
            elif t == '+' or t == '-':
                before = t
    print('Possible')
    print(' '.join(output))
