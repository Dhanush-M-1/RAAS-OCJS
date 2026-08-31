# from scipy.special import comb,perm
# import math
# x=1-2*(0.1587)
# for i in range(1,10):
#     print(1-(1-x)**i)

a,b=input().split()
n=int(input())
print(a,b)
for i in range(n):
    nex1,nex2=input().split()
    if a==nex1:
        a=nex2
    elif b==nex1:
        b=nex2
    print(a,b)


				   			    		 	 	 	 		 				