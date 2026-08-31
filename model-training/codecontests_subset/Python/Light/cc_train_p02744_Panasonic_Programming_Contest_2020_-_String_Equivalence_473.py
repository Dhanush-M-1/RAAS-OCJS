n=int(input())

def go(s):
   global n
   if len(s)==n:
       print(s)
       return
   l=max(s)
   for i in range(ord('a'),ord(l)+1):
       go(s+chr(i))
   if l < 'z':
       go(s + chr(ord(l) + 1))

go("a")