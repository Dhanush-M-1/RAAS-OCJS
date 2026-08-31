n,k=map(int,input().split())
hours=0
while n!=0:
    n-=1
    hours+=1
    if hours%k==0:
        n+=1
print(hours)
    
