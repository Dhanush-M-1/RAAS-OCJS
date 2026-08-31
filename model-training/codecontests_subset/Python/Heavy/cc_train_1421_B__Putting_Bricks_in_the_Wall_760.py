import sys
import math
def II():
	return int(sys.stdin.readline())
 
def LI():
	return list(map(int, sys.stdin.readline().split()))
 
def MI():
	return map(int, sys.stdin.readline().split())
 
def SI():
	return sys.stdin.readline().strip()
t = II()
for q in range(t):
    n = II()
    l = []
    for i in range(n):
        l.append(list(SI()))
    a,b = l[0][1],l[1][0]
    c,d = l[n-1][n-2], l[n-2][n-1]
    ans = []
    if a == b and c == d:
        if a == b == c == d:
            ans.append([1,2])
            ans.append([2,1])
    elif a == b:
        if c == a:
            ans.append([n,n-1])
        else:
            ans.append([n-1,n])
    elif c == d:
        if c == a:
            ans.append([1,2])
        else:
            ans.append([2,1])
    else:
        if a == c:
            ans.append([1,2])
            ans.append([n-1,n])
        else:
            ans.append([1,2])
            ans.append([n,n-1])
    print(len(ans))
    for i in ans:
        print(*i)

    