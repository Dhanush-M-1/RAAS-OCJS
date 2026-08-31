password = input()
n = int(input())
know = []
for _ in range(n):
  know.append(input())
  
def hi():
  for x in know:
    for y in know:
      if password in x + y:
        return "YES"
  return "NO"

print(hi())
exit(0)