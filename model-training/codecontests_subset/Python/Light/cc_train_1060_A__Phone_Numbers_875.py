n = int(input())
if n != 0:
    s = input()
else:
    s = ''
k = s.count('8')
count = n // 11
print(min(k, count))