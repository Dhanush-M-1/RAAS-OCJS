n = int(input())
for i in range(n):
    s = list(map(int,input().split()))
    if s[0]>s[2]:
        print(s[2])
    elif s[2]>=s[0] and s[0]<=s[1]:
        q=s[2]
        b=s[1]
        q=(b//q)*q+q
        print(q)
    else:
        print(q) 