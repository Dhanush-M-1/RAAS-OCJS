import math
class codeforces:
    def holidays(self,n):
        ans=(int(n/7))*2
        if n%7>=2:
            max=ans+2
        else:
            max=ans+n%7
        if n%7>5:
            min=ans+(n%7)-5
        else:
            min=ans
        print(int(min),int(max))
             
        
    def robots(self,n,k,l):
        r=int((-1+math.sqrt(1+8*k))/2)
##        print(r)
        temp=int(k-(r*(r+1))/2)
##        print(temp)
##        print(type(temp))
        if temp==0:
            print(l[r-1])
        else:
            print(l[temp-1])
     

s=codeforces()
##n=int(input())
##s.holidays(n)
##
d=[int(x) for x in input().split()]
n=d[0];k=d[1]
l=[int(x) for x in input().split()]

##d=[4,5]
##l=[10,4,18,3]
##d=[2,2]
##l=[1,2]
##n=d[0];k=d[1]
s.robots(n,k,l)


    
