r=[int(x) for x in input().split()]
c=[int(x) for x in input().split()]
d=[int(x) for x in input().split()]

ans=False
for w in range(1,10):
  for x in range(1,10):
    for y in range(1,10):
      for z in range(1,10):
        if w!=x and w!=y and w!=z and x!=y and x!=z and y!=z:
          if r[0]==w+x and r[1]==y+z:
            if c[0]==w+y and c[1]==x+z:
              if d[0]==w+z and d[1]==x+y:
                ans=True
                print(w,x)
                print(y,z)
                break
if not ans:
  print(-1)
