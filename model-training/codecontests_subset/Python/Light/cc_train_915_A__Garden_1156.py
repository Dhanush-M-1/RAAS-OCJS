#/usr/bin/python3

# MC721A
# 27 de março de 2020
# Rogério Meirelles - RA160245

import math

n, k = map(int, input().split()) 
segment = [int(s) for s in input().split()]

segment.sort(reverse=True)

for s in segment:
    if k % s == 0:
        print(math.floor(k / s))
        break
		  			    			 	 	  	 		   			