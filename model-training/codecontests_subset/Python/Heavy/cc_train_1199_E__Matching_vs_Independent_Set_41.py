'''
cho n và  m:
có 3*n đỉnh và m mối quan hệ giữa các đỉnh
kết hợp:
tập hợp các cạnh không có chung điểm cuối
độc lập:
tập hợp các điểm mà không có bất kì điểm nào nằm trong chung trong một cạnh
output:
in ra nếu có tập có độ lớn n thỏa kết hợp hoặc độc lập
nếu có hai kết quả in ra bất kì kết quả nào cũng được.

'''

from sys import stdin
input=stdin.readline
t=int(input())
for k in range(t):
    n,m=map(int,input().split(' '))
    a=[i for i in range(1,n+1)]
    qq=set(range(1,3*n+1))
    e=[]
    for i in range(1,m+1):
        a1,a2=map(int,input().split(' '))
        if a1 in qq and a2 in qq:
            e.append(i)
            qq.remove(a1)
            qq.remove(a2)
    if(len(qq)>=n):
        print('IndSet')
        print(*list(qq)[:n])
    else:
        print('Matching')
        print(*e[:n])

    

  
   


    
    

