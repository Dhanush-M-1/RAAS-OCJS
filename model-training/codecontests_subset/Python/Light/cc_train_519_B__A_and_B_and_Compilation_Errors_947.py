n=int(input())
x=list(map(int,input().split()))
y=list(map(int,input().split()))
z=list(map(int,input().split()))
result=x[0]
for i in x[1:]:
    result=result^i
for i in y:
    result=result^i    
print(result)
result=y[0]
for i in y[1:]:
    result=result^i    
for i in z:
    result=result^i    
print(result)

