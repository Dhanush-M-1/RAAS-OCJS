def rl():
    return list(map(int,input().split()))
def arp(arr):
    return ' '.join([str(i) for i in arr])

from collections import deque,Counter
from math import ceil,sqrt,log2,log,floor

for _ in range(int(input())):
    n, = rl()
    i = 0
    ans = []
    while i<n:
        s = input()
        if i<=1:
            if i==0:
                ans.append(s[1])
            else:
                ans.append(s[0])
        if i>=n-2:
            if i==n-2:
                ans.append(s[-1])
            else:
                ans.append(s[-2])
        i+=1
    cout = []
    l = [(1,2), (2,1),(n-1,n),(n,n-1)]
    if ans[0]==ans[1]==ans[2]==ans[3]:
        cout.append((1,2))
        cout.append((2,1))
    elif ans[0]=='0' and ans[1]=='0' and ans[2]=='0' and ans[3]=='1':
        cout.append(l[2])
    elif ans[0]=='0' and ans[1]=='0' and ans[2]=='1' and ans[3]=='0':
        cout.append(l[3])
    elif ans[0]=='0' and ans[1]=='0' and ans[2]=='1' and ans[3]=='1':
        pass
    elif ans[0]=='0' and ans[1]=='1' and ans[2]=='0' and ans[3]=='0':
        cout.append(l[0])
    elif ans[0]=='0' and ans[1]=='1' and ans[2]=='0' and ans[3]=='1':
        cout.append(l[0])
        cout.append(l[-1])
    elif ans[0]=='0' and ans[1]=='1' and ans[2]=='1' and ans[3]=='0':
        cout.append(l[1])
        cout.append(l[-1])
    elif ans[0]=='0' and ans[1]=='1' and ans[2]=='1' and ans[3]=='1':
        cout.append(l[1])
    elif ans[0]=='1' and ans[1]=='0' and ans[2]=='0' and ans[3]=='0':
        cout.append(l[1])
    elif ans[0]=='1' and ans[1]=='0' and ans[2]=='0' and ans[3]=='1':
        cout.append(l[0])
        cout.append(l[2])
    elif ans[0]=='1' and ans[1]=='0' and ans[2]=='1' and ans[3]=='0':
        cout.append(l[0])
        cout.append(l[-1])
    elif ans[0]=='1' and ans[1]=='0' and ans[2]=='1' and ans[3]=='1':
        cout.append(l[0])
    elif ans[0]=='1' and ans[1]=='1' and ans[2]=='0' and ans[3]=='0':
        pass
    elif ans[0]=='1' and ans[1]=='1' and ans[2]=='0' and ans[3]=='1':
        cout.append(l[-1])
    elif ans[0]=='1' and ans[1]=='1' and ans[2]=='1' and ans[3]=='0':
        cout.append(l[2])
    elif ans[0]=='1' and ans[1]=='1' and ans[2]=='1' and ans[3]=='1':
        cout.append(l[2])
        cout.append(l[-1])
    print(len(cout))
    for i in cout:
        print(*i)