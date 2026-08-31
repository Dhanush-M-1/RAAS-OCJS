n = int(input())
q = ['a']
for i in range(n-1):
   nq = []
   for s in q:
      stop = ord(max(s)) + 2
      for i in range(ord('a'), stop):
         nq.append(s + chr(i))
   q = nq

for s in q:
   print(s)
