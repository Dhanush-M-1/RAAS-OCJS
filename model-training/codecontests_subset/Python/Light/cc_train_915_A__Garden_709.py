nbaldes, tamanhojardim = list(map(int, input().split()))
baldes = list(map(int, input().split()))
baldes.sort()
baldes = baldes[::-1]
achou = False
i = 0
while not achou:
    if tamanhojardim % baldes[i] == 0 and tamanhojardim >= baldes[i]:
        print(int(tamanhojardim/baldes[i]))
        achou = True
    else:
        i += 1

   	  	 	 	  	 	   				  		 	