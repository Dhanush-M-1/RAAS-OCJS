n = int(input())
answer = []
for i in range(n):
    length = int(input())
    lis = list(map(int,input().split()))
    max_2 = 0
    sor = []
    
    for j in range(length):
        if lis[j] == -1:
            if j != 0 and lis[j-1] != -1 :
                sor.append(lis[j-1])
            if j != length-1 and lis[j+1] != -1:
                sor.append(lis[j+1])
    sor.sort()

    if len(sor) > 0:
        max_1 = int((sor[0]+sor[-1])/2)
    else:
        max_1 = 0
    for j in range(length):
        if lis[j] == -1:
            lis[j] = max_1

    for j in range(length-1):
        max_2 = max(max_2,abs(lis[j]-lis[j+1]))


    print(max_2,max_1)

  				 	 	  			  	 		  	   				