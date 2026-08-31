p1, p2 = input().split(" ")

print(p1, p2)

n = int(input())

for i in range(n):
  morreu, trocou = input().split(" ")
  if morreu == p1:
    p1 = trocou
    print(p1, p2)
  else:
    p2 = trocou
    print(p1, p2)