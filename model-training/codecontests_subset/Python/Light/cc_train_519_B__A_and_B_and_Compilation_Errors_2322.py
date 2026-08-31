import sys

n = int(input())

a = [int(i) for i in input().split()]
b = [int(i) for i in input().split()]
c = [int(i) for i in input().split()]

sum_a = sum(a)
sum_b = sum(b)
sum_c = sum(c)

print(sum_a - sum_b)
print(sum_b - sum_c)

	  	    	  	  		 					  		 	  	