n = int(input())
x = []
h = []
for i in range(n):
  a, b = map(int, input().split())
  x.append(a)
  h.append(b)

INF = -10**9
stay = [INF] * (n + 1)
left = [INF] * (n + 1)
right = [INF] * (n + 1)
stay[-1] = 0
left[-1] = 0
right[-1] = 0

for i in range (n):
  stay[i] = max(stay[i - 1], left[i - 1], right[i - 1])
  
  if i == 0 or x[i] - h[i] > x[i - 1]:
    left[i] = max(left[i - 1], stay[i - 1]) + 1
  
  if x[i] - h[i] > x[i - 1] + h[i - 1]:
    left[i] = right[i - 1] + 1
    
  if i == n - 1 or x[i] + h[i] < x[i + 1]:
    right[i] = max(right[i - 1], stay[i - 1], left[i - 1]) + 1

print(max(left[n - 1], right[n - 1], stay[n - 1]))