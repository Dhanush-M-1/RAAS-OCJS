n=int(input())
v0=sorted(list(map(int,input().split())))
v1=sorted(list(map(int,input().split())))
v2=sorted(list(map(int,input().split())))
i=0
while(i<len(v1) and v0[i]==v1[i]):
  i+=1
print(v0[i])
i=0
while(i<len(v2) and v1[i]==v2[i] ):
  i+=1
print(v1[i])

       	 		 		  	 	 	 					 		