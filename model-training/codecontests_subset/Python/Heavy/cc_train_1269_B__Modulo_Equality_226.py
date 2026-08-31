import sys,math,string,bisect
input=sys.stdin.readline
from collections import deque,defaultdict,Counter
L=lambda : list(map(int,input().split()))
Ls=lambda : list(input().split())
M=lambda : map(int,input().split())
I=lambda :int(input())

def find_gt(a, x):
    i = bisect_right(a, x)
    if i != len(a):
        return a[i]
    raise ValueError
def rightRotate(lists, num): 
    output_list = [] 
      
    # Will add values from n to the new list 
    for item in range(len(lists) - num, len(lists)): 
        output_list.append(lists[item]) 
      
    # Will add the values before 
    # n to the end of new list     
    for item in range(0, len(lists) - num):  
        output_list.append(lists[item]) 
          
    return output_list
def fun(a,b,j,x,k,ans):
    g=b[j:]+b[:j]
    s=a[::]
    for i in range(len(a)):
        s[i]=(s[i]+x)%k
    if(s==g):
        ans.append(x)
        
n,k=M()
a=L()
b=L()
a.sort()
b.sort()
ad=defaultdict(int)
bd=defaultdict(int)
ad=Counter(a)
bd=Counter(b)
if(a==b):
    print(0)
else:
    a=sorted(list(set(a)))
    b=sorted(list(set(b)))
    l=[]
    m=[]

    for i in a:
        l.append(ad[i])
    for i in b:
        m.append(bd[i])

    done=0
    ans=[]
    for j in range(len(m)):
        if(l[0]==m[j]):
            if(a[0]%k<b[j]):
                x=b[j]-(a[0]%k)
            elif(a[0]%k>b[j]):
                x=k-(a[0]%k)+b[j]
            g=fun(a,b,j,x,k,ans)
    print(min(ans))

        
                
    
