def list_difference(a1, a2):
  for i in range(len(a2)):
    if a1[i] != a2[i]:
      return(a1[i])
  return a1[-1]

n = int(input())
a = sorted(list(map(int, input().split())))
b = sorted(list(map(int, input().split())))
c = sorted(list(map(int, input().split())))
print(list_difference(a, b))
print(list_difference(b, c))