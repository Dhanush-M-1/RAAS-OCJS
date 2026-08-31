n=int(input())
def b(s):
  if len(s)==n:
    print(s)
    return
  for i in "abcdefghijklmnopqrstuvwxyz":
    b(s+i)
    if max(list(s))==chr(ord(i)-1):return
b("a")