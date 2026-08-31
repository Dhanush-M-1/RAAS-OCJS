n=int(input())
l=['0']*3
for i in range(3):
    k=list(map(int,input().split()))
    l[i]=sum(k)
l=[l[x]-l[x+1] for x in range(2)]
print (l[0])
print (l[1])
    


            
    
