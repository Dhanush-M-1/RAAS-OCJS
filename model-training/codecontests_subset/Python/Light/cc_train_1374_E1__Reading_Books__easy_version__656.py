import sys
def get_ints():return map(int,sys.stdin.readline().split())

n,k=get_ints();
both=[];Alice=[];bob=[]
for _ in range(n):
  in_list=list(get_ints())
  t,a,b=in_list[0],in_list[1],in_list[2]
  if a&b:
      both.append(t)
  elif a:
    Alice.append(t)
  elif b:
    bob.append(t)
Alice.sort()
bob.sort()
l=min(len(Alice),len(bob))
for i in range(l):
   both.append(Alice[i]+bob[i])
if len(both)<k:
  print(-1)
else:
  both.sort()
  print(sum(both[:k]))
  
