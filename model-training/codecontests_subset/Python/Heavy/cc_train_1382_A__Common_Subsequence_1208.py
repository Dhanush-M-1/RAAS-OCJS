'''
Name : Jaymeet Mehta
codeforces id :mj_13
Problem : 
'''
from sys import stdin,stdout
test=int(stdin.readline())
for _ in range(test):
    n,k = map(int,stdin.readline().split())
    a = [int(x) for x in stdin.readline().split()]
    b = [int(x) for x in stdin.readline().split()]
    ans=False
    for i in a:
        if i in b:
            ans=True
            ind=i
            break
        if ans:
            break
    if ans:
        print("YES")
        print(1,ind)
    else:
        print("NO")