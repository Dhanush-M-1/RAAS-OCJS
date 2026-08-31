n, m = [int(x) for x in input().split()]

choice = []

for i in range(n):
    choice.append([int(x) for x in input().split()[1:]])

result = []

for i in range(m):
    result.append(False)

for i in range(len(choice)):
    for j in range(len(choice[i])):
        index = choice[i][j] - 1
        result[index] = True

final_result = True

for i in result:
    if not i:
        final_result = False

if final_result:
    print("YES")
else:
    print("NO")

		 	 		 	  		 		  	   						  	