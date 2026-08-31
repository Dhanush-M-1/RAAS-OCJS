import sys
 
input = sys.stdin.readline
 
n, k = map(int, input().split())
o, a, b = [], [], []
for i in range(n):
       q, w, e = map(int, input().split())
       if w == e and w:
              o.append(q)
       elif w and not e:
              a.append(q)
       elif w or e:
              b.append(q)
i = j = l = 0
done = 0
ans = 0
o.sort()
a.sort()
b.sort()
while (i < len(o) or j < len(a) and l < len(b)) and done < k:
       if i < len(o) and (j >= len(a) or l >= len(b) or j < len(a) and l < len(b) and o[i] <= a[j]+b[l]):
              ans += o[i]
              i += 1
              done += 1
       elif l < len(b) and j < len(a):
              ans += a[j]+b[l]
              j += 1
              l += 1
              done += 1
 
print(ans if done >= k else -1)