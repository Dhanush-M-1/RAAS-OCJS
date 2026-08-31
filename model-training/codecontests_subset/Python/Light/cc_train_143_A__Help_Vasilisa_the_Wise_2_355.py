from itertools import permutations 

perm = permutations([1, 2, 3,4,5,6,7,8,9], 4) 
x=0
r1,r2=map(int,input().split())
c1,c2=map(int,input().split())
d1,d2=map(int,input().split())
check=True
for i in list(perm): 
    ans=permutations(list(i),4)
    for j in list(ans):
        k=list(j)
        a=k[0]
        b=k[1]
        c=k[2]
        d=k[3]
        #a b
        #c d
        if((a+b)==r1 and (c+d)==r2 and (a+c)==c1 and (b+d)==c2 and (a+d)==d1 and (b+c)==d2):
            print(a,b)
            print(c,d)
            check=False
        if(not check):
            break
    if(not check):
        break
if(check):
    print(-1)