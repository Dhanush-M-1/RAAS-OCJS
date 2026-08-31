n=int(input())
l=list(map(int,input().split()))
b=[]
for i in range(2):
    b=list(map(int,input().split()))
    print(sum(l)-sum(b))
    l=b.copy()
    
        