# cook your dish here
def B(n,arrr):  
    a= bin(n).replace("0b", "")  
    b='0'*(len(arrr)-len(a))+a
    return b
def product(bi,arrr):
    pro=1
    for i in range(len(arrr)):
        if bi[i]=='1':
            pro=pro*arrr[i]
    return pro
            
x=int(input())
x1=x
m=0
ans=x1
arr=[]
for i in range(2,int(x1**0.5)+1):
    
    if x%i==0:
        y=1
        while x%i==0:
            x=x//i
            y=y*i
        arr.append(y)
    
for i in range(1,2**len(arr)):
    p=product(B(i,arr),arr)
    q=x1//p
    m=max(p,q)
    ans=min(m,ans)
print(ans,x1//ans)
    
    
    
    


    