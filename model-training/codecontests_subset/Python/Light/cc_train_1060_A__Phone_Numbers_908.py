n, s = int(input()), input()
e = s.count('8')
m = 0
for i in range(e+1):
    m = max(m, min(i, (n-i)//10))
print(m)
