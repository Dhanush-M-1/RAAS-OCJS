re = 500000
n = int(input())
ls = list(map(int,input().split()))
my_ls = []
f_ls  = []
my_sec = -1
f_sec  = -1
for i in ls:
    if i <=re:
        my_ls.append(i)
    elif i>re:
        f_ls.append(i)
if my_ls!=[]:
    my_sec = max(my_ls) - 1 
if f_ls !=[]:
    f_sec  = 10**6 - min(f_ls)
print(max(my_sec,f_sec))
 	       	     	 	    			 			 	