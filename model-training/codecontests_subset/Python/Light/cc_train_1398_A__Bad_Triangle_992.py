"""T=int(input())
for _ in range(0,T):
    n=int(input())
    a,b=map(int,input().split())
    s=input()
    s=[int(x) for x in input().split()]
    for i in range(0,len(s)):
        a,b=map(int,input().split())"""


T=int(input())
for _ in range(0,T):
    n=int(input())
    s=[int(x) for x in input().split()]
    if((s[0]+s[1])<=s[-1]):
        print(1,2,n)
    else:
        print(-1)

