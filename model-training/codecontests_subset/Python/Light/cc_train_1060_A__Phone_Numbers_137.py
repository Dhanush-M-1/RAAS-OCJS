n =  int(input())
s = input()
p = s.count('8')
m = n // 11

if n < 11 or p == 0:
    print(0)
else:
    print(min(p,m))