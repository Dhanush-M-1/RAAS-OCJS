def triangle(a):
    j=len(a)//2
    for i in range(len(arr)):
        while(j<len(arr)):
            if a[i]+a[i+1]<=a[j]:
                print(i+1,i+2,j+1)
                return
            j+=1
    print(-1)
n=int(input())
for i in range(n):
    m=int(input())
    arr=[0]*m
    arr=list(map(int,input().split()))
    triangle(arr)