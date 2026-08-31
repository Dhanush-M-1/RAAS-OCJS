n=int(input())
xa=0
xb=0
xc=0
a=[int(x) for x in input().split()]
b=[int(x) for x in input().split()]
c=[int(x) for x in input().split()]
for i in a:
        xa^=i
for i in b:
        xb^=i
for i in c:
        xc^=i
print(xa^xb)
print(xb^xc)

  		 			 		 	 		 	  	 		 				