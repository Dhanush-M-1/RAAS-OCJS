n=int(input())#n个m=input()
m=int(input())
s=map(int,str(m))
i=0
for k in s:
    if k==8:
        i=i+1
j=int(n/11)
if i>j:
    print(j)
else:
    print(i)

		 			     		  			 	  	   		 		