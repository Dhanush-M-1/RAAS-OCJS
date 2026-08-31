# def hehe(a,n):
#     if n==1 or n==2:
#         return -1
#         
#     a1=list(a)
#     a1.sort()
#     
#     a2=list(a1)
#     a2.reverse()
#     
#     acopy=list(a)
#     for i in range (0,n,1):
#         for j in range(i+1,n,1):
#             if(a[i]==a[j]):
#                 continue
#             temp=acopy[i]
#             acopy[i]=acopy[j]
#             acopy[j]=temp
#             if acopy!=a2 and acopy!=a1:
#                 return [i+1,j+1]
#             acopy=list(a)
#     return -1
def hehe(a,n):
    if n==1 or n==2:
        return -1
        
    a1=list(a)
    for i in range(1,n-1,1):
        if a1[i-1]==a1[i]==a1[i+1]:
            continue
        elif a1[i-1]<=a1[i]<=a1[i+1] or a1[i-1]>=a1[i]>=a1[i+1]:
            if a1[i-1]==a1[i]:
                return [i+1,i+2]
            elif a1[i]==a1[i+1]:
                return [i,i+1]
            else:
                return [i,i+1]
        elif a1[i-1]<a1[i]>a1[i+1] or a1[i-1]>a1[i]<a1[i+1]:
            if a1[i-1]!=a1[i+1]:
                return [i,i+2]
            else:
                if i<n-2:
                    if a1[i+2]==a1[i]:
                        return [i,i+1]

    return -1         

n=int(input())

a=input().split()
a=[int(i) for i in a]

answer=hehe(a,n)
if answer==-1:
    print(-1)
else:
    print(*answer, sep=" ")
    

