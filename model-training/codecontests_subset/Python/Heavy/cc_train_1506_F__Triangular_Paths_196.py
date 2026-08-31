import io,os,sys
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
import heapq

T = int(input())
r = 1
while r<=T:
    n = int(input())
    arr_r = list(map(int, input().split()))
    arr_c = list(map(int, input().split()))

    seq = [[1,1]]
    for i in range(n):
        seq.append([arr_r[i],arr_c[i]])
    seq = sorted(seq)
    ans = 0
    for i in range(1,n+1):
        diff = (seq[i][0]-seq[i-1][0])-(seq[i][1]-seq[i-1][1])
        if diff==0 and (seq[i-1][0]+seq[i-1][1])%2==0:  ans += (seq[i][0]-seq[i-1][0])
        elif (seq[i-1][0]+seq[i-1][1])%2==0:   
            ans += (diff)//2
        elif (seq[i-1][0]+seq[i-1][1])%2==1:
            ans += (diff+1)//2
    

    print(ans)




    r += 1
