n = int(input())
a = list(input())
c = a.count('8')
l = len(a)//11
if c>l:
    print(l)
else:
    print(c)