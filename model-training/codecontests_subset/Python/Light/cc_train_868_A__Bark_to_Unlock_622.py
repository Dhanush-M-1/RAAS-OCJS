pw=input()
n=int(input())
d=[]
for i in range(n):
   sem=input()
   d.append(sem)
for i in d:
   for j in d:
      if pw in i+j:
         print('YES')
         exit(0)
print('NO')

      
