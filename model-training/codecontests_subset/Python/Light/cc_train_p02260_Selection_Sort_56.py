#ALDS1_2_B
n = int(input())
a = [int(i) for i in input().split()]
cnt = 0
for ni in range(n):
  mini = ni
  for ii in range(ni,n):
    if a[ii] < a[mini]:
      mini = ii
  if mini != ni:
    cnt += 1
    a[ni], a[mini] = a[mini], a[ni]
print(" ".join([str(i) for i in a]))
print(cnt)
