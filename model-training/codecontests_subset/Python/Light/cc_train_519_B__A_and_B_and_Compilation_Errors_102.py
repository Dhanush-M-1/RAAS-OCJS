t=int(input())
sum=0
sum1=0
sum2=0
for i in input().split():
	sum+=int(i)
for j in input().split():
	sum2+=int(j)
sum2=sum-sum2
sum=sum-sum2
for k in input().split():
	sum-=int(k)
print(sum2)
print(sum)
 	  	  	   		  		     				 	  	