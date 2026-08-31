password=input()
n= int(input())
lst=[]
a,b,c=True , True,True
for i in range (n):
 lst.append(input())
if password in lst or password[1]+password[0] in lst:
 print('YES')
else:
 for i in range (n):
  if lst[i][0]==password[1] and a:
   for j in range(n):
    if lst[j][1]==password[0]:
     print('YES')
     b =False
     c=False
     a=False
     break
    elif j==n-1 and i==n-1:
     b=True
     a=False
     break
 for i in range (n):
  if lst[i][1]==password[0] and b:
   for j in range(n):
    if lst[j][0]==password[1]:
     print('YES')
     c=False
     b=False
     
     break
    elif j==n-1 and i==n-1:
     c=False
     print('No')
     break
 if c:
  print('NO')
  		 	  			    	 	 			 		  				