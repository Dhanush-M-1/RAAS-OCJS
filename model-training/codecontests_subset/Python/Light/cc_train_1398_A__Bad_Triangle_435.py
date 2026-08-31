t=int(input())
for _ in range(t):
    n=int(input())
    ar=[int(i) for i in input().strip().split(" ")]
    a=ar[0]
    b=ar[1]
    c=ar[-1]
    if a+b>c:
        print(-1)
    else:
        print(1,2,n)
