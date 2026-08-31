'''input
7
5
-1 10 -1 12 -1
5
-1 40 35 -1 35
6
-1 -1 9 -1 3 -1
2
-1 -1
2
0 -1
4
1 -1 3 -1
7
1 -1 7 5 2 -1 5
'''
import sys
read = lambda: list(map(int,sys.stdin.readline().strip().split()))

# try:
for _ in range(int(input())):
    n = int(input())
    m1 = 10**10
    m2 = -1
    diff = 0
    last = -1
    a = read()
    n1 = n-1
    for ind,i in enumerate(a):
        if i>=0 and last>=0:
            diff = max(diff,abs(i-last))
        last = i
        if i>=0 and ((ind>0 and a[ind-1]==-1) or (ind<n1 and a[ind+1]==-1)):
            if m1>i:
                m1 = i
            if m2<i:
                m2 = i
    if m1==10**10 or m2==-1:
        print(0,23)
        continue
    k = (m1+m2)//2
    print(max(diff,m2-k),k)
# except Exception as e:
#   print(e)
