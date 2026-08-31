n = int(input())
s = input()
if n >= 11:
    print(min(s.count('8'), n // 11))
else:
    print(0)