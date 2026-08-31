[a,b] = map(int, input().split())
z = []
n = []
for x in range(a):
 n = list(map(int, input().split()))
 for i in range(len(n)):
   if n[i] not in z and n[i] != 0 and i > 0: z.append(n[i])
if len(z) == b: print('YES')
else: print('NO')