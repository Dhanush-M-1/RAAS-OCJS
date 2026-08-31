n, k = input().strip().split(' ')
n, k = [int(n), int(k)]
a = list(map(int, input().strip().split(' ')))
#for i in range(n):
 #    a.append(int(input()))
list.sort(a, reverse=True)
for j in range(n):
     if k%a[j] ==0:
          print(int(k/a[j]))
          break

