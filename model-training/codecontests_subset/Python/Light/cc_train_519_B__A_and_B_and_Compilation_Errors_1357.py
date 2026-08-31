from collections import Counter

length = int(input())
org_errors = Counter(map(int, input().split()))
first_error = Counter(map(int, input().split()))
second_error = Counter(map(int, input().split()))

first = org_errors - first_error
elem = (list(first.elements()))
print(elem[0])

second = first_error - second_error
elem = (list(second.elements()))
print(elem[0])
    	 				  	      		 		 		