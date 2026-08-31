'''try:
  t=int(input())
  for z in range(t):
    n=int(input())
    
    if(n&n-1==0):
        
        print("-1")

    else:
 
        print(2,3,1, end=" ")
        i=4
        while(i<n+1):
            if(i & i-1 ==0):
                print(i+1,i,end=" ")
                i+=2
            else:
                print(i,end=" ")
               
                i+=1
        print()


        
        




      
    
except:
  pass

def f(n):
    if(n==1):
        return 1
    
    
    c=1
    for i in range(1,int(n**0.5)+1):
        if(n%i==0):
            c+=1
    
  
    return c
t=int(input())
for z in range(t):
    n=int(input())
    if(n==1):
        print(1)
    else:
        ans=0
        for i in range(1,n):
            ans+=f(i)

            if(ans>=n):
                break
        print(i)


x,y,z=map(int,input().split())
s=input()
a=s[:y]
b=s[y+1:]
a=sorted(a)
b=sorted(b)
ans=[]
for i in range(y):
    for j in range(y):
        s1=a[i]+b[j]
        ans.append(s1)
print(ans[z-1])'''


'''/s=input()
t=input()
ans=""
i=0
j=0
n1=len(s)
n2=len(t)
while(i<n1 and j<n2):
    ans+=s[i]
    ans+=t[j]
    i+=1
    j+=1
while(i<n1):
    ans+=s[i]
    i+=1
while(j<n2):
    ans+=t[j]
    j+=1
print(ans'''


n=int(input())
s=input()
a=[]
b=[]
i=0
while(i<n-1):
    s1=s[i]+s[i+1]
    if(s1 not in b):
        a.append([s1,0])
        b.append(s1)
    else:
        ind=b.index(s1)
        c=a[ind][1]
        a[ind][1]+=1
    i+=1
a.sort(key=lambda x:x[1])
l=len(a)
print(a[l-1][0])
