def answer(n,A):
    if n<=2:
        return n
    count=2
    r=A[0][0]
    for i in range(1,n-1):
        if A[i][0]-A[i][1]>r:
            count+=1
            r=A[i][0]
        else:
            if A[i][0]+A[i][1]<A[i+1][0]:
                count+=1
                r=A[i][0]+A[i][1]
            else:
                r=A[i][0]
                
    return count
    
    

n=int(input())
A=[]
for i in range(n):
    x,h=map(int,input().split())
    A.append([x,h])
print(answer(n,A))