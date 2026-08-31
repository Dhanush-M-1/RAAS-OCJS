line1=[]
line2=[]
line3 =[]
n=int(input())
x=input()
line1=x.split(" ")	
x=input()
line2=x.split(" ")	
x=input()
line3=x.split(" ")
sum1=sum2=sum3=0
for number in line1:
	sum1+=int(number)
for number in line2:
	sum2+=int(number)
for number in line3:
	sum3+=int(number)
print(sum1-sum2)
print(sum2-sum3)
    	 				   	  			 			    			