# from scipy.special import comb,perm
# import math
# x=1-2*(0.1587)
# for i in range(1,10):
#     print(1-(1-x)**i)
k=int(input())
s=list(input())
dict={}
for i in s:
    if i in dict.keys():
        dict[i]+=1
    else:
        dict[i]=1

for i in  dict.keys():
    if dict[i]%k!=0:
        print(-1)
        exit(0)
    else:
        dict[i]//=k
ans=[]
for i in dict.keys():
    for j in range(dict[i]):
        ans.append(i)
for i in range(k):
    print(''.join(ans),end='')
			 							      	     		 					