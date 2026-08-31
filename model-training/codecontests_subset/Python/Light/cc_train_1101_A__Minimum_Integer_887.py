

q = int(input())

def check_left(l,r,d):
  return d

def check_right(l,r,d):
  
  result = 0
  if (r%d == 0):
    result = r+d
  else:
    result = r - (r%d) + d



  return result


def minimum_integer(l,r,d):
  if (l-d <= 0):
    return check_right(l,r,d)
  else:
    return check_left(l,r,d)

for i in range(q):
  l, r, d  = [int(e) for e in input().split()]
  print(minimum_integer(l,r,d))