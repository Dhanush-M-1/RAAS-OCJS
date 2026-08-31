from sys import stdin
"""
n=int(stdin.readline().strip())
n,m=map(int,stdin.readline().strip().split())
s=list(map(int,stdin.readline().strip().split()))
s=stdin.readline().strip()
"""
m=int(stdin.readline().strip())
for i in range(m):
    n=int(stdin.readline().strip())
    s=list(map(int,stdin.readline().strip().split()))
    arr=[s[0],s[1],s[-1]]
    if arr[-1]>=arr[0]+arr[1]:
        print(1,2,n)
    else:
        print(-1)
