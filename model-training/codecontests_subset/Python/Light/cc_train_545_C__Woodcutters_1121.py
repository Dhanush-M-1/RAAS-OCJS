n = int(input())
num = [[int(x) for x in input().split()] for i in range(n)]
outcome = 0
if n == 1:
   print(1)
else:
   for i in range(1,n-1):
       if num[i][1] < num[i][0] - num[i-1][0] :
           outcome += 1
       elif num[i+1][0]-num[i][0] > num[i][1]:
              outcome += 1
              num[i][0] += num[i][1]
   print(outcome+2)
        