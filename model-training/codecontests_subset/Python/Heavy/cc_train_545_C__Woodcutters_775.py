n=int(input())
x=[0]*n
h=[0]*n

for i in range(n):
  x[i],h[i]=[int(k) for k in input().split()]
  

l=[-1]*n
r=[-1]*n


def f():
  
  count = 0
  left=x[0]
  i = 0
  while True:
    if n == 1:
      count = 1
      break

    if i == 0:
      count=1

      #print(f"fall {i} left")
      left=x[0]
    elif i==n-1:
      count+=1
      #print(f"fall {i} right")
      break
    elif h[i]<x[i]-left:
      #rint(f"fall {i} left")
      count+=1
      left=x[i]
    elif h[i]<x[i+1]-x[i]:
      #print(f"fall {i} right")
      count+=1
      left=x[i]+h[i]
    else:
      #print(f"leave {i} standing")
      left=x[i]
    i+=1

  print(count)
  return count


f()

