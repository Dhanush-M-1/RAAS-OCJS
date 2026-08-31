def ques1(n,a):
    if a[0] + a[1] <= a[-1]:
        print(1,2,n)
    else:
        print(-1)
 
t = int(input())
for i in range(t):
    n = int(input())
    a = [int(i) for i in input().split()]
    ans = ques1(n,a)
    ans