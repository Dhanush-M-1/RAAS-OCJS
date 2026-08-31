from collections import deque
n=int(input())
ans=deque(['a'])
while True:
  a=ans.popleft()
  if len(a)==n:
    ans.appendleft(a)
    break
  m=max(a)
  for i in range(ord(m)-96+1):
    ans.append(a+chr(97+i))
print(*ans,sep='\n') 