sa = input()

a = [0] * 26
for i in sa:
    a[ord(i) - ord('a')] += 1

sb = input()

b = [0] * 26
for i in sb:
    b[ord(i) - ord('a')] += 1

sc = input()

c = [0] * 26
for i in sc:
    c[ord(i) - ord('a')] += 1

def zu(n):
    m = 1000000000
    for i in range(26):
        if n * b[i] > a[i]:
            return -1
        if c[i] > 0:
            m = min(m, (a[i] - n * b[i]) // c[i])
    return n + m

n = 0
m = 0
v = 0
for i in range(100000):
    u = zu(i)
    if u < 0:
        break
    if v < u:
        v = u
        n = i
        m = u - i

print(sb * n + sc * m, end = '')
for i in range(26):
    a[i] -= n * b[i] + m * c[i]
    print(chr(i + ord('a')) * a[i], end = '')

    










