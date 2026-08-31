'''
Name : Jaymeet Mehta
codeforces id :mj_13
Problem : 
'''
from sys import stdin,stdout
from math import log2
test=int(stdin.readline())
for _ in range(test):
    N=int(stdin.readline())
    if N==1:
        print(0)
        continue
    if N%3:
        print(-1)
        continue
    cnt2=0
    cnt3=0
    while(N&1^1):
        N=N//2
        cnt2+=1
    while(not N%3):
        N=N//3
        cnt3+=1
    if N!=1 or cnt2>cnt3:
        print(-1)
        continue
    diff=cnt3-cnt2
    ans=diff+cnt3
    print(ans)