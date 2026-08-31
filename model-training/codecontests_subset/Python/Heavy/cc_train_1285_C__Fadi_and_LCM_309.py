n=int(input())
p=n
ans={}
a=[]
for i in range(2,int(n**0.5)+1):
    if p%i==0:
        ans[i]=0
        while(p%i==0):
            p//=i
            ans[i]+=1
        a.append(i**ans[i])
if p!=1:
    ans[p]=1
    a.append(p)
#print(ans)
#print(a)
if len(a)==1:print(1,n)
else:
    mmax=[n,1,n]
    for i in range(1,2**len(a)):
        tmp=1
        for j in range(len(a)):
            if (i&(1<<j)):
                tmp*=a[j]
        #print(tmp)  
        if mmax[0]>max(tmp,n//tmp):
            mmax=[max(tmp,n//tmp),tmp,n//tmp] 
    #print(mmax)
    print(mmax[1],mmax[2]) 




    

