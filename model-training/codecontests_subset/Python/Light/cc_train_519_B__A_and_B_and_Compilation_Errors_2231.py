def error(x,y):
  x.sort()
  y.sort()
  for i in range(len(y)):
    if x[i] != y[i]:
      return x[i]

  return x[len(x)-1]



n = int(input())

x = [0] * n
y = [0] * (n-1)
z = [0] * (n-2) 

a = input()
x = [int(x) for x in a.split()]

b = input()
y = [int(x) for x in b.split()]

c = input()
z = [int(x) for x in c.split()]

print(error(x,y))
print(error(y,z))


