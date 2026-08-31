a = input(); n = int(input())
b = *(input() for i in range(n)),
c = (''.join(map(lambda x: b[i] + x, b)) for i in range(n))
print(('NO', 'YES')[any(a in i for i in c)]) 