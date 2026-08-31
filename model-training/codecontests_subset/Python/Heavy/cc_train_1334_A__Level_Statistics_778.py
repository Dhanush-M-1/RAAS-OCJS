def res(n,a):
    for i in range(n):
        if a[i][1]>a[i][0]:
            return "NO"
        else:
            if i!=n-1:
                if a[i+1][0]<a[i][0] or a[i+1][1]<a[i][1]:
                     return "NO"
                elif (a[i+1][0]-a[i][0]) < (a[i+1][1]-a[i][1]):
                      return "NO"
    return "YES"
 
 
t=int(input())
for i in range(t):
    a=[]
    n=int(input())
    for j in range(n):
        temp=[int(x) for x in input().split()]
        a.append(temp)
    print(res(n,a))