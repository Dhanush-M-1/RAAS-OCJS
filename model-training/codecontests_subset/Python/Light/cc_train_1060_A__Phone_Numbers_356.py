n = int(input())
s = input()
c = s.count('8')
g = n//11
if c<=g:
    print(c)
else:
    print(g)
