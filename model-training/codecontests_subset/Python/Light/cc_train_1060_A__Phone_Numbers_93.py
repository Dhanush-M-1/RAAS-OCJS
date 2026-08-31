n = int(input())
a = list(input())
# print(a)
cnt = a.count('8')
l = len(a)//11
print(min(cnt,l))
