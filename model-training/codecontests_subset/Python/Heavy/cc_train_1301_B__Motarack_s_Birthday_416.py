def solve_b():
  n = int(input())
  for _ in range(n):
     b()

def b():
  n = int(input())
  l = [int(x) for x in input().split()]
  l2 = []
  l2 = [l[index-1] for index, x in enumerate(l) if (index > 0 and x == -1 and l[index-1] != -1)] +\
    [l[index+1] for index, x in enumerate(l) if (index < n-1 and x == -1 and l[index+1] != -1)]
  if l2 == []:
    print("{} {}".format(0, 42))
    return
  min_l2 = min(l2)
  max_l2 = max(l2)
  k = (min_l2 + max_l2) //2
  l3 = [x if x != -1 else k for x in l]
  m = max([abs(l3[index]-l3[index+1]) for index, x in enumerate(l3[:(n-1)])])
  print("{} {}".format(m, k))

solve_b()