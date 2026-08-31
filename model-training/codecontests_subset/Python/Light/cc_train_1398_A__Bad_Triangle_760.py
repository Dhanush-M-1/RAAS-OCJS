t = int(input())
answer = [0]*t
for i in range(t):
    s = int(input())
    a = [int(i) for i in input().split()]
    if a[0] + a[1] <= a[-1]:
        answer[i] = '1 2 '+str(s)
    else:
        answer[i] = -1
for i in range(t):
    print(answer[i])