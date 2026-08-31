m,n=map(int,input().split())
lph=[]

for i in range(m):
         s=list(map(int,input().split()))
         lph+=s
         lph.remove(s[0])      
w=set(lph)
e=[]
for i in range(1,n+1):
         e.append(i)
e1=set(e)


if w==e1:
         print("YES")
else:
         print("NO")
         
