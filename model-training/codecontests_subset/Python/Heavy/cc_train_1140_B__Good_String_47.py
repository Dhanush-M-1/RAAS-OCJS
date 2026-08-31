# n = int(input())
# str = input()
# a = str.split()
# ma = 0
# cnt = 0
# for i in range(0, n):
#     ma = max(int(a[i]), ma)
#     if(ma == i+1):
#         cnt += 1
# print(cnt)
T = int(input())
for cas in range(0,T):
    n = int(input())
    s = input()
    s = list(s)
    if(s[0]== '<' and s[n-1] == '>'):
        cnt1 = 0
        cnt2 = 0
        for i in range(0, n):
            if(s[i] != '<'):
                cnt1 = i
                break
        for i in range(n-1, -1, -1):
            if(s[i] != '>'):
                cnt2 = n-i-1
                break
        print(min(cnt1, cnt2))
    else:
        print('0')