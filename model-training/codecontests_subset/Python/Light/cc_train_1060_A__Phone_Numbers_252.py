n = input()
s = input()
a = 0
for i in s:
    a += i == '8'
print(min(a, len(s)//11))
