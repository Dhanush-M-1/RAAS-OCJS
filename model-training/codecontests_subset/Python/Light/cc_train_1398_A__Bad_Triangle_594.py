a = int(input())
for i in range(a):
   b = int(input())
   c = list(map(int,input().split()))
   if c[0] + c[1] > c[-1]:
      print(-1)
   else:
      print(1, 2, len(c))