n=int(input())

for _ in range(n):
    leng=int(input())
    array=input().strip().split(" ")
    x=int(array[0])
    y=int(array[1])
    z=int(array[-1])
    if(x+y<=z):
        print("%d %d %d" % (1,2,leng))
    else:
        print("-1")