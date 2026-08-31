full, n = [int(i) for i in input().split()]
half = 0
hours =0
while full > 0:
  hours = hours + full
  half = half + full
  full = half//n
  half = half - (half//n)*n
print(hours)