n,k =map(int,input().split())
arr =list(map(int,input().split()))
while True:
    index =None
    var =-1
    for i in range(n):
        if (arr[i] > var):
            index =i
            var =arr[i]
    if (k%var == 0):
        print (int(k/var))
        break
    arr[index] =-1
