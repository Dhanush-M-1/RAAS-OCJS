for _ in range(int(input())):
  n, *l = input(), *map(int, input().split())
  print(' '.join(['1', '2', n]) if l[0]+l[1]<=l[-1] else -1)