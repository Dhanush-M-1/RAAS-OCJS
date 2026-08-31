s=input().split()
a=int(s[0])
b=int(s[1])
sisa=0
new=a
ini=0

while new!=0:
	ini+=new
	a=new
	new=(a+sisa)//b
	sisa=(a+sisa)%b
print(ini)
 		  			  	 	 	 		 			 		 	  		