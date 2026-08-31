from sys import stdin, stdout
input = stdin.readline
#print = stdout.write


n = int(input())
a = list(map(int,input().split()))
ans = []
if n==1:
    print(1,1)
    print(1)
    print(1,1)
    print(1)
    print(1,1)
    print(-a[0]-2)
else:
    ans.append([1,n-1])
    temp = []
    for i in range(n-1):
        temp.append(a[i] * (n-1))
        a[i]+=a[i]*(n-1)
    ans.append(temp)
    
    ans.append([2,n])
    temp = [0]*(n-2) + [a[-1]*(n-1)]
    a[-1] += temp[-1]
    ans.append(temp)
    
    ans.append([1,n])
    temp = []
    for i in range(n):
        temp.append(-a[i])
    ans.append(temp)
    for a in ans:
        print(*a, sep=' ')
        