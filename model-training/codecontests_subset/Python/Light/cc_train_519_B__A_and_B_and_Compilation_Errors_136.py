#F - A and B and Compilation Errors

from collections import Counter

n = int(input())
set1 = Counter(map(int, input().split()))
cor1 = Counter(map(int, input().split()))
cor2 = Counter(map(int, input().split()))
print((set1 - cor1).most_common(1)[0][0])
print((cor1 - cor2).most_common(1)[0][0])
		   			   					  		   	 			 		