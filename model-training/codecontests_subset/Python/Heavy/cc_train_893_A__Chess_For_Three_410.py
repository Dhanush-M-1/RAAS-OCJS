n=int(input())
l=[int(input()) for i in range(n)]
x=3
y=True
for i in range(n):
      if i==0:
            if (l[i]==x):
                  y=False
                  print("NO")
                  break
      else:
            if l[i]!=l[i-1] and l[i]!=x:
                  print("NO")
                  y=False
                  break
            else:
                  if x!=l[i]:
                        x=6-l[i]-x
                  else:
                        x=6-l[i]-l[i-1]
if y:
      print("YES")