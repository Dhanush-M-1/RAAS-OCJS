n=int(input())
a=list(map(int,input().split()))
c=[]
for i in a:
    c.append(min(i-1,10**6-i))
print(max(c))

    


        
