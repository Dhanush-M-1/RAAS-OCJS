n=int(input())
l1=[]
l2=[]
l3=[]
l1=list(map(int,input().split()))
l2=list(map(int,input().split()))
l3=list(map(int,input().split()))
a=0
b=0
c=0
for i in l1:
    a=a+i
for i in l2:
    b=b+i
for i in l3:
    c=c+i
print(a-b,b-c)

    

  
    
