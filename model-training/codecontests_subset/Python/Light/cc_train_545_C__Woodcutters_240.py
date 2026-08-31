n = int(input())
k=l=co=0
co=2
arr = [list(map(int, input().split())) for i in range(n)]
prev=arr[0][0]
for i in range(1,n-1):
    l,h=arr[i]
#    print(l,h,prev,arr[i+1][0])
    if l-h>prev:
        co+=1
        prev=l
    elif l+h<arr[i+1][0]:
        prev=l+h
        co+=1
    else:
        prev=l    
print(co if n>1 else 1)            
