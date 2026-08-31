t=int(input())
for _ in range(t):
    n = int(input())
    ar=list(map(int,input().split()))
    if(ar[0]+ar[1]<=ar[n-1]):
        print('1 2',end=' ')
        print(n)
    else:
        print('-1')
       
           
