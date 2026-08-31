from collections import Counter
n = int(input())

beginning = Counter(list(map(int, input().split(" "))))
first = Counter(list(map(int, input().split(" "))))
second = Counter(list(map(int, input().split(" "))))

diff = beginning-first
print(list(diff.elements())[0])

diff2 = first-second
print(list(diff2.elements())[0])
			 	   			  		 		  		 	  		 		