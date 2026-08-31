from collections import Counter
n = int(input())

primeira = list(map(int, input().split(" ")))
segunda = list(map(int, input().split(" ")))
terceira = list(map(int, input().split(" ")))

first = Counter(primeira)
second = Counter(segunda)
third = Counter(terceira)

diff = first-second
print(list(diff.elements())[0])

diff2 = second-third
print(list(diff2.elements())[0], end='')
		  			   				   	  							 	