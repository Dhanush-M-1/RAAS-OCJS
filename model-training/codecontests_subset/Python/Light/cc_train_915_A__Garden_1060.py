n, k = map(int, input().split())
a = list(map(int, input().split()))
max = 0

for i in range(0, n):
     if k % a[i] == 0 and a[i] > max:
          max = a[i]
         
print(k // max)
