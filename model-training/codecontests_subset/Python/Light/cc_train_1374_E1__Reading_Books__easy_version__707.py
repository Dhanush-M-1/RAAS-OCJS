import sys
input = sys.stdin.readline
 
a,b = list(map(int, input().split()))

AL = []
A = []
B = []
 
for _ in range(a):
    n = list(map(int, input().split()))
    
    if n[1]==1 and n[2]==1:
        AL.append(n[0])
    elif n[1]==1 and n[2]==0:
        A.append(n[0])
    elif n[1]==0 and n[2]==1:
        B.append(n[0])
    
A.sort()
B.sort()

for k in range(min(len(A), len(B))):
    AL.append(A[k] + B[k])
    
if len(AL) < b:
    print(-1)
else:
    AL.sort()
    ans = sum(AL[:b])
    print(ans)