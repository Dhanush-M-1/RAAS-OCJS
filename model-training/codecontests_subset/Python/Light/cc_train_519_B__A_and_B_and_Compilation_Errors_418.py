n = int(input())
compil1 = [int(x) for x in input().split(" ")]
compil2 = [int(x) for x in input().split(" ")]
compil3 = [int(x) for x in input().split(" ")]
compil1.sort()
compil2.sort()
compil3.sort()

for i in range(len(compil1)):

    if(i == len(compil1)-1):
        print(compil1[i])
        break
    elif(compil1[i] != compil2[i]):
        print(compil1[i])
        break
for i in range(len(compil2)):

    if (i == len(compil2) - 1):
        print(compil2[i])
        break
    elif(compil2[i] != compil3[i]):
        print(compil2[i])
        break
		   	 	  	     				 	 	  		 		