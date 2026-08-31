n = int(input())
s = input()
e = s.count('8')
a = divmod(n, 11)
if e == 0:
    print(0)
else:
    print(min(a[0], e))
