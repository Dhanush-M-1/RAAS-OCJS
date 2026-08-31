n=int(input())
ans=[]
def b(s):
  if len(s)==n:
    ans.append(s)
    return
  for i in "abcdefghijklmnopqrstuvwxyz":
    b(s+i)
    if max(list(s))==chr(ord(i)-1):return
b("a")
ans.sort()
for i in ans:print(i)