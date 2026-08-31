n=int(input())
var=[int(x) for x in input().split()]
var1=[int(x) for x in input().split()]
var2=[int(x) for x in input().split()]
from collections import Counter 
counter1=Counter(var)
counter2=Counter(var1)
counter3=Counter(var2)
answer1=counter1-(counter2)
answer2=counter2-(counter3)
for letter in answer1:
	print(letter)
for letter in answer2:
	print(letter)