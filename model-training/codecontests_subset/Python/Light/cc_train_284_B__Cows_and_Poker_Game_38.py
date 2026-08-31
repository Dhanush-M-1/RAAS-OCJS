n, s = int(input()), input()
a, i = s.count('A'), s.count('I')
f = n - (a + i)
if i == 1 and (f > 0 or a > 0):
    print(i)
elif i == 0 and a > 0:
    print(a)
else:
    print(0)
