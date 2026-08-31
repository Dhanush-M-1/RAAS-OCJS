# problem6
N=int(input())
import math
#最大公約数

#最小公倍数
def union_lcm(lists):
    if len(lists)==1:
        return lists[0]
    elif len(lists)>1:
        num=lists[0]
        for i in range(1,len(lists)):
            num=num*lists[i]//math.gcd(num,lists[i])
        return num
    
if N>3:
    if N%2!=0:
        print((max(N,1))*(max(1,N-1))*(max(1,N-2)))
    else:
        ans=0
        for i in range(max(1,N-50),N+1):
            for j in range(max(1,N-50),N+1):
                for k in range(max(1,N-50),N+1):
                    ans=max(ans,union_lcm([i,j,k]))
        print(ans)
if N==3:
    print(6)
if N==2:
    print(2)
if N==1:
    print(1)