(n, k) = map(int, input().split())
lst = [int(x) for x in input().split()]
a = 1
for i in range(n):
   if ((k % lst[i]) == 0) and ((k // lst[i]) < (k // a)):
      a = lst[i]
print(k // a)

   
