q=int(input())
for _ in range(q):
	ln=list(map(int,input().split()))
	i=1
	if ln[2]<ln[0]:
		print(ln[2])
	elif ln[2]>ln[1]:
		print(ln[2])
	else:
	    x=ln[1]-ln[2]
	    print(ln[1]+(ln[2]-(x%ln[2])))
	    '''i=ln[1]+1
	    #print(i)
	    while(1):
	        if i%ln[2]==0:
	            print(i)
	            break
	        i=i+1'''