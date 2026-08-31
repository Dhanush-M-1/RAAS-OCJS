potential1, potential2 = input().split()
n = int(input())
print(potential1, potential2)
for i in range(n):
  killed, newPotential = input().split()
  if killed == potential1:
    potential1 = newPotential
  else:
    potential2 = newPotential
  print(potential1, potential2)