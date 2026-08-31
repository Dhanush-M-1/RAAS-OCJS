n = int(input())
list_input = list(map(int,input().split()))
firstc = {}
for bug in list_input:
    if bug in firstc:
        firstc[bug]+=1
    else:
        firstc[bug] = 1

list_input = list(map(int,input().split()))
secondc = {}
for bug in list_input:
    firstc[bug]-=1
    if bug in secondc:
        secondc[bug]+=1
    else:
        secondc[bug] = 1

for key in firstc:
    if firstc[key] == 1:
        print(key)
        firstc[key] -= 1

list_input = list(map(int,input().split()))
for bug in list_input:
    secondc[bug]-=1
    if bug in firstc:
        firstc[bug]+=1
    else:
        firstc[bug] = 1

for key in secondc:
    if secondc[key] == 1:
        print(key)

 	      		  		 		 		 		  	 	 		