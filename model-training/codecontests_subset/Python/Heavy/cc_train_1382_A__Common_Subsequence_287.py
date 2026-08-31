# python3
from queue import Queue
import sys

def get_ints():
    return list(map(int,sys.stdin.readline().strip().split()))

if __name__ == "__main__":
    t=int(input())
    for i in range(t):
        n,m=get_ints()
        n_nums=[0]*1001
        a=get_ints()
        for i in range(n):
            n_nums[a[i]]+=1
        b=get_ints()
        condn=False
        for j in b:
            if n_nums[j]>0:
                condn=True
                print('YES')
                print(1,j)
                break
        if condn==False:
            print('NO')


