
def myfun(li,indices,curr,start,end):
    if(start<end):
        
        aa=li[start]
        a=start
        for i in range(start,end):
            if(li[i]>aa):
                a=i
                aa=li[i]
                
       
        indices[a]=curr
        myfun(li,indices,curr+1,start,a)
        myfun(li,indices,curr+1,a+1,end)
        
        
    
    
    


for _ in range(int(input())):
    n=int(input())
    l=[int(x) for x in input().split()]
    indices=[-1 for i in range(n)]
    myfun(l,indices,0,0,n)
    print(*indices)