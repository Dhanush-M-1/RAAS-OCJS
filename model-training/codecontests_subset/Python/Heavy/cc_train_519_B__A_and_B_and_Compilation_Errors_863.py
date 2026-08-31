"""
Nome: Stefano Lopes Chiavegatto
RA: 1777224
"""

errors = int(input())

comp1 = input()
list_comp1 = comp1.split(" ")
list_comp1 = [int(i) for i in list_comp1]
dic1 = {}
for i in list_comp1:
	if i not in dic1:
		dic1[i] = 0
	else:
		dic1[i] = dic1[i] + 1

comp2 = input()
list_comp2 = comp2.split(" ")
list_comp2 = [int(i) for i in list_comp2]
dic2 = {}
for i in list_comp2:
	if i not in dic2:
		dic2[i] = 0
	else:
		dic2[i] = dic2[i] + 1

comp3 = input()
list_comp3 = comp3.split(" ")
list_comp3 = [int(i) for i in list_comp3]
dic3 = {}
for i in list_comp3:
	if i not in dic3:
		dic3[i] = 0
	else:
		dic3[i] = dic3[i] + 1

for i in dic1:
	if i not in dic2:
		print(i)
	else:
		if dic1[i] != dic2[i]:
			print(i)

for i in dic2:
	if i not in dic3:
		print(i)
	else:
		if dic2[i] != dic3[i]:
			print(i)
	   	   		  			 	     	 					