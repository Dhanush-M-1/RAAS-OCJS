n, m = (int(i) for i in input().split())
days = n
rem = 0
while n:
  rem += n%m
  n = n//m
  n += rem//m
  rem = rem%m
  days += n
print(days)