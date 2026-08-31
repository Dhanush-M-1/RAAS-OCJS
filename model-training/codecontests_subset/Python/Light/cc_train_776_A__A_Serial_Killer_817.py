t,v = input().split(' ')
n=int(input())
i=0
l = []
l1= []
l1.append(t)
l1.append(v)
l.append(l1)
while(i<n):
    k1,k2 = input().split(' ')
    l1=[]
    if(t==k1):
        l1.append(k2)
        l1.append(v)
        l.append(l1)
        t=v
        v=k2
    if(v==k1):
        l1.append(k2)
        l1.append(t)
        l.append(l1)
        t=t
        v=k2
    i=i+1
for i in l:
    print(i[0],i[1])

	  	 			 	  	 		 		 	 		   	 	