for _ in 'T' * int(input()):
  n = int(input())
  *k, = [int(x) for x in input().split()]
  if k[0] + k[1] <= k[-1]:
    print(1, 2, n)
  else:
    print(-1)