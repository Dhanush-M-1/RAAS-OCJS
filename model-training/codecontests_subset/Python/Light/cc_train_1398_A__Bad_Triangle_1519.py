from sys import stdin

t=int(input())
for T in range(t) :
    n=int(input())
    arr=[int(x) for x in stdin.readline().split()]
    flag=0
    for i in range(n-2) :
        for k in range(2,n) :
            if arr[i]+arr[i+1]<=arr[k] :
                print(i+1,i+2,k+1)
                flag=1
                break
        if flag==1 :
            break
        elif flag==0 :
            print(-1)
            break