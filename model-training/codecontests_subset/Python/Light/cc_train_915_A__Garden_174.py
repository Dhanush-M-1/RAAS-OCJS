#B - Garden

[n, k] = map(int, input().split())

a = list(map(int, input().split()))
hours = [k / x if k % x == 0 else 101 for x in a ]
print('%d' % min(hours))

 			  			 	 	 	    			 								