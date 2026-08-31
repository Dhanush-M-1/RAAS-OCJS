n = int(input())
ss = input()

n1 = n//11
if n1 == 0:
  print(0)
  exit()

s8s = [s for s in ss[:len(ss)] if s == '8']
print(min(n1, len(s8s)))
