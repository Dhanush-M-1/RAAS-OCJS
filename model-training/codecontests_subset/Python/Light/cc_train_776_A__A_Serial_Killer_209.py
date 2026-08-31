first, second = input().split()

n = int(input())
print(first, second)
for i in range(n):
   corp, alive = input().split()
   if corp == first:
      first = alive
   else:
      second = alive
   print(first, second)