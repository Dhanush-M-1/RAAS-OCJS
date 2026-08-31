import math as mt
def tran(n,arr):
    if arr[0]+arr[1]>arr[-1]:
        return [-1]
    else:
        return [1,2,n]

if __name__ == '__main__':
    t = int(input())
    ans = []
    for i in range(t):
        n=int(input())
        arr = list(map(int, input().rstrip().split()))
        r = tran(n,arr)
        ans.append(r)
    for i in ans:
        print(*i)
