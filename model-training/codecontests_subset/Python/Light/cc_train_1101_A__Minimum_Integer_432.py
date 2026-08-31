n = int(input())
for i in range(n):
     a = list(map(int, input().split()))
     count = 1
     if a[2] < a[0] or a[2] > a[1]:
          print( a[2])
     else:
         print( (int(a[1]/a[2]) + 1) *a[2])