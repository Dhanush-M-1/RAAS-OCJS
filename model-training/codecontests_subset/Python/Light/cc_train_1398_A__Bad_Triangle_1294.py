def triangle(n,a):
    b=a[0]+a[1]
    for x in range(n):
        if a[x]>=b:
            print(1,2,x+1)
            return
    print(-1)
    return

t=int(input())
array=[]
for i in range(t):
    a=[]
    a.append(int(input()))
    a.append(list(map(int,input().split(" "))))
    array.append(a)
for x in array:
    triangle(*x)