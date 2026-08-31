n = int(input())
s = input()
c, nph = s.count('8'), n//11
print(min(c,nph))