n=int(input())
p=list(map(int,input().split()))
d=sum(p)
l=[]
for ch in range(2):
    p=list(map(int,input().split()))
    e=sum(p)
    l.append(d-e)
    d=e
for ch in l:
    print(ch)
        
    
