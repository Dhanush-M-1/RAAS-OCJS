import math
# hello
# bros
# this
# is 
#my 
# code
def check1(x,y):
    ans1=math.gcd(x,y)
    ans=((x*y)/(ans1))
    if ans==nn:
        return(True)
    else:
        return(False)
        
nn=int(input())

mm=int(math.sqrt(nn))

mxn=10000000000000000000000000000000000
 
for i in range(1,mm+1):
    if nn%i==0:
        if check1(i,nn//i)==True:
        
            mxx=max(i,nn//i)
            
            mxn=min(mxn,mxx)
            
            ans1,ans2=i,nn//i
            
print(ans1,ans2)