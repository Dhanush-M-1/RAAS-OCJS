n = int(input())
s = input()
eights = s.count('8')
print(min(eights, len(s) // 11))
