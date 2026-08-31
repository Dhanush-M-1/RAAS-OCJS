'''
Name : Jaymeet Mehta
codeforces id :mj_13
Problem : 
'''
from sys import stdin,stdout
from bisect import bisect
test=int(stdin.readline())
for _ in range(test):
    n=int(stdin.readline())
    a = [int(x) for x in stdin.readline().split()]
    ok=False
    for i in range(n-1):
        if a[i]+a[i+1]<=a[-1]:
            print(i+1,i+2,n)
            ok=True
            break
    if not ok:
        print(-1)