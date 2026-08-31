q=int(input())
for i in range (q):
    a=input().split()
    a[0]=int(a[0])
    a[1]=int(a[1])
    a[2]=int(a[2])
    if a[2] < a[0] or a[2] > a[1]:
        print(a[2])
    else:
        print((a[2]-(a[1]%a[2]))+a[1])