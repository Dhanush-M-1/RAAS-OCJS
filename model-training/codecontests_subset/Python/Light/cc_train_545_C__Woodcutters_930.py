n = int(input())
S=[]
for i in range (n):
    S.append([int (x) for x in input().split()])
S.append([10**10,0])
ans = 0
lastone = -10**10
for i in range (n):
    if S[i][0]-S[i][1]>lastone:
        ans+=1
        lastone = S[i][0]
    elif S[i][0]+S[i][1]<S[i+1][0]:
        ans+=1
        lastone = S[i][0]+S[i][1]
    else:
        lastone = S[i][0]
print (ans)