n = int(input())
m = input()
f = m.count('8',0,len(m))
if 11*f < n:
    print(f)
else:
    print(n // 11)
