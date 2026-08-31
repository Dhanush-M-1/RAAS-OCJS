import sys
input=sys.stdin.buffer.readline

#arr[i]+arr[j]!=arr[k]

t=int(input())
for _ in range(t):
    n=int(input())
    arr=[int(x) for x in input().split()]
    
    if arr[0]+arr[1]<=arr[n-1]:
        print('{} {} {}'.format(1,2,n))
    else:
        print(-1)