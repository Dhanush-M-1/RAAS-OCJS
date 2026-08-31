def factorise(n):
    dic={} 
    while n%2==0:
        if 2 in dic:
            dic[2]+=1
        else:
            dic[2]=1
        n=n/2
        
    for i in range(3,int(n**0.5)+1):
        while n%i==0:
            if i in dic:
                dic[i]+=1
            else:
                dic[i]=1
            n=n/i
    if n>2:
        dic[n]=1
    return dic
x = int(input())
dic = factorise(x)
factors = list(dic.keys())
arr = [i**(dic[i]) for i in factors]
arr.sort()
l=len(factors)
if x==1:
    print(1,1)
elif factors[0]!=x:
    all_sub=[]
    for i in range(2**l): 
        subset = [] 
        # consider each element in the set 
        for j in range(l): 
  
            # Check if jth bit in the i is set.  
            # If the bit is set, we consider  
            # jth element from set 
            if (i & (1 << j)) != 0: 
                subset.append(arr[j])
        all_sub.append(subset)
    
    m=10**13
    for i in all_sub:
        t=1
        for j in i:
            t*=j
        m=min(max(t,x/t),m)
    print(int(m),int(x/m))
            
    
else:
    print(1,factors[0])


   