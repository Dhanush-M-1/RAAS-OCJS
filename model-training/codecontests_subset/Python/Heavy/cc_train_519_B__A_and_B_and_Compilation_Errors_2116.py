n = int(input())
dic1 = {}
dic2={}
dic3={}

[dic1.__setitem__(i,dic1.get(i,0)+1) for i in [int(j) for j in input().split()]]
[dic2.__setitem__(i,dic2.get(i,0)+1) for i in [int(j) for j in input().split()]]
[dic3.__setitem__(i,dic3.get(i,0)+1) for i in [int(j) for j in input().split()]]



if len(dic1.keys() - dic2.keys()) != 0:
    print(list(dic1.keys() - dic2.keys())[0])
else:
    [print(x) if y != z else None for x, y, z in list(zip(sorted(dic1.keys()), map(lambda x: x[1], sorted(dic1.items())), map(lambda x: x[1], sorted(dic2.items()))))]

if len(dic2.keys() - dic3.keys()) != 0:
    print(list(dic2.keys() - dic3.keys())[0])
else:
    [print(x) if y != z else None for x, y, z in list(zip(sorted(dic2.keys()), map(lambda x: x[1], sorted(dic2.items())), map(lambda x: x[1], sorted(dic3.items()))))]

	 	    	 	   		 						  		 	 	