def f(k,arr):
    #assert (j==len(arr))
    a=arr[0]
    b=arr[1]
    for i in range(k):
        if arr[i]>=(a+b):
           return('1 2 '+str(i+1))
    return '-1'


a=input()
n=int(a)
for i in range(n):
    j=int(input())
    a=list(map(int,input().rstrip().split()))
    print(f(j,a))