import time

def solve(val):
   count = 0
   if val == 1:
      return 0
   
   if val <= 2:
      return -1

   while val != 1:
      # print(val)
      if val % 6 == 0:
         val = int(val/6)
         count+=1
      else:
         val = int(val * 2)
         count+=1

      if val == 1:
         return count
      if val == 0:
         return -1
      if (val % 2 == 0) and (val % 3 != 0):
         return -1

if __name__ == "__main__":

   t = int(input())
   values = []
   for _ in range(t):
      values.append(int(input()))
   for i in range(len(values)):
      print(solve(values[i]))
