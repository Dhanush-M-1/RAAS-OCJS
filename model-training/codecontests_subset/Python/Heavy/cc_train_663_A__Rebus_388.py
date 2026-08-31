import sys
s = input()

n = int(s[s.index('=')+1:])
plus = s.count('+')+1
minus = s.count('-')

diff = increse_pos = count = neg = a = b = 0
if plus - minus < n:
    diff = n + minus
    a = diff // plus
    b = diff % plus
    if (b != 0 and a+1 > n ) or (a > n):
        neg = 1
    else:
        increse_pos = 1

elif plus - minus > n:
    diff = plus - n
    if minus > 0:
        a = diff // minus
        b = diff % minus
    else:
        neg = 1

    if (neg == 0 and b != 0 and a + 1 > n) or (neg == 0 and a > n):
        neg = 1
    else:
        increse_pos = 0
else:
    diff = 0
    a = 1

sign = 1
res = ''
if neg == 0:
    for ch in s:
        if ch == '?' and sign == 1:
            if increse_pos == 1:
                if b > 0:
                    res += str(a+1)
                    count += a+1
                    b -= 1
                else:
                    res += str(a)
                    count += a
            else:
                res += str(1)
                count += 1
            sign = 0
        elif ch == '?' and sign == 0:
            if increse_pos == 0:
                if b > 0:
                    res += str(a + 1)
                    count -= a+1
                    b -= 1
                else:
                    res += str(a)
                    count -= a
            else:
                res += str(1)
                count -= 1
        elif ch == '+':
            sign = 1
            res += ch
        elif ch == '-':
            sign = 0
            res += ch
        else:
            res += ch
    print('Possible')
    print(res)
else:
    print('Impossible')
