n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))
map1 = {}
map2 = {}
for i in c:
    map1.update({i: map1.get(i, 0)+1})

respb = -1
for i in b:
    map2.update({i: map2.get(i, 0)+1})

    if(respb == -1): 
        value = map1.get(i, -1)
        if value == -1:
            respb = i
        else:
            if value == 0:
                respb = i
            else:
                map1.update({i: value-1})
respa = -1
for i in a:
    if(respa == -1): 
        value = map2.get(i, -1)
        if value == -1:
            respa = i
        else:
            if value == 0:
                respa = i
            else:
                map2.update({i: value-1})
print(respa)
print(respb)
    
		 		   	  	  		 	  		 	   	 		