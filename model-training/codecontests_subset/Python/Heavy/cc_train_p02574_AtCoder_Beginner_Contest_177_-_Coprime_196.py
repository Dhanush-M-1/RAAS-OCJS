N = int(input())
A = list(map(int, input().split()))
M = max(A) + 1

counts = [0 for _ in range(M)]
for a in A:
  counts[a] += 1

integers = [1 for _ in range(M)]
integers[0] = 0
integers[1] = 0
max_count = 0
for i in range(M):
   if integers[i] >= 1:
    count = 0
    for j in range(i,M,i):
      count += counts[j]
      integers[j] = 0
    max_count = max(max_count,count)

if max_count == N:
  answer = 'not coprime'
elif max_count >= 2:
  answer = 'setwise coprime'
else:
  answer = 'pairwise coprime'

print(answer)