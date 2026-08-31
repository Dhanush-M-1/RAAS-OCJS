n = int(input())
l = list(input())
maxi = n // 11
e = l.count('8')
print(min(maxi, e))