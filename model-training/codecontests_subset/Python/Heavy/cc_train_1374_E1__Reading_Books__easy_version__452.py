
n,k=map(int,input().split())
time=[]
a=[]
b=[]
count_a=0
count_b=0
for i in range(n):
    t,a1,b1=map(int,input().split())
    time.append(t)
    a.append(a1)
    b.append(b1)
    
    if a1==1:
        count_a+=1
    if b1==1:
        count_b+=1
#print(count_a,count_b)   
if count_a<k or count_b<k:
    print(-1)
       
else:
    both=[]
    a_not_b=[]
    b_not_a=[]
    
    for i in range(n):
        if a[i]==1 and b[i]==1:
            both.append(time[i])
        elif a[i]==1 and b[i]==0:
            a_not_b.append(time[i])
        elif a[i]==0 and b[i]==1:
            b_not_a.append(time[i])
    
    #print(both,a_not_b,b_not_a)
    a_not_b.sort()
    b_not_a.sort()
    both_len=len(both)
    a_not_b_len=len(a_not_b)
    b_not_a_len=len(b_not_a)
    final=[]
    req_len=min(a_not_b_len,b_not_a_len)
    for i in range(req_len):
        final.append(a_not_b[i]+b_not_a[i])
    #print(both,final)
    
    final.extend(both)
    final.sort()
    if len(final)<k:
        print(-1)
    else:
        ans=0
        for i in range(k):
            ans+=final[i]
        #print(final)
        print(ans)
    
        
    
    
    
        
        