    #from _typeshed import SupportsKeysAndGetItem
import sys
#sys.stdin=open("input.txt","r");
#sys.stdout=open("output.txt","w")
####### GLOBAL ###############
MOD=1000000007
no=lambda:print("NO")
yes=lambda:print("YES")
_1=lambda:print(-1)
ari=lambda:[int(_) for _ in input().split()]
cin=lambda:int(input())
cis=lambda:input()
show=lambda x: print(x)
########### END #########
######
test_case=1
#test_case=input().split()
test_case=int(input())
######
def ans():
    lno,m,n=ari()
    mono=ari()
    poly=ari()
   # mono.sort()
   # poly.sort()
    ans=[]
    c=0
    p=0
    m1=0
    #print(poly,mono)
   # index=max(n,m)
    while m1<m or  p<n:
        if m1<m and mono[m1]==0:
            m1+=1
            ans.append(0)
            lno+=1
        elif p<n and poly[p]==0:
            lno+=1
            p+=1
            ans.append(0)
        elif p<n and poly[p]<=lno:
            ans.append(poly[p])
            p+=1
        elif m1<m and mono[m1]<=lno:
            ans.append(mono[m1])
            m1+=1        
        else:
            #print(p,n,ans)
            _1()
            #print(ans,poly[p],lno)
            return
    print(*ans)
    return
    
        
for _ in range(test_case):
    gar=input().split()
    ans()