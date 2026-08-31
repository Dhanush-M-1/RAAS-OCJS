n = int(input())
s = input()
c8 = s.count('8')
re = n-c8
t = n//11
print(min(c8,t))
