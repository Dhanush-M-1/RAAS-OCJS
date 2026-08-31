def game(n,A):
    maxi_p=A[0][0]
    maxi_c=A[0][1]
    if maxi_c>maxi_p:
        return "NO"
    for i in range(1,n):
        if A[i][0]<maxi_p or A[i][1]<maxi_c or A[i][0]<A[i][1] or (A[i][0]-A[i-1][0]<A[i][1]-A[i-1][1]):
            return "NO"
        maxi_p=max(maxi_p,A[i][0])
        maxi_c=max(maxi_c,A[i][1])
    return "YES"
t=int(input())
for i in range(t):
    n=int(input())
    arr=[]
    for i in range(n):
        a,b=map(int,input().split())
        arr.append([a,b])
    print(game(n,arr))


# In[ ]:




