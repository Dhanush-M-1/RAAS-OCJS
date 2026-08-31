n = int(input())
s = input()
eight = s.count('8')
notEight = n - eight
res = 0
for i in range(1, eight + 1):
    res = max(min(i, (notEight + eight - i) // 10), res)
print(res)