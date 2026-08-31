def Ainp():
  n = input()
  A = []
  for pp in range(int(n)):
    l = input()
    task = []
    for i in range(int(l)):
      n, m = list(map(int, input().split()))
      task.append([n,m])
    A.append(task)
  
  for t in A:
     ok = True
     for i, pc in enumerate(t):
       p, c = pc
       if p < c:
         print('NO')
         ok = False
         break
       if i:
         prevp, prevc = t[i - 1]
         if (prevp > p) or (prevc > c) or (p - prevp < c - prevc):
           #print((prevp > p) , (prevc > c) , (p - prevp < c - prevc))
           ok = False
           print('NO')
           break
     if ok: 
       print('YES')



Ainp()
