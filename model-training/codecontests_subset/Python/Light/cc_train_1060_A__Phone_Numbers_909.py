import collections 
n=int(input())
m=input()
L=list(m)
e=L.count('8')

if ((e==0)or (n<11)) :
     print(0)
else :
     print (min((n//11),e))
