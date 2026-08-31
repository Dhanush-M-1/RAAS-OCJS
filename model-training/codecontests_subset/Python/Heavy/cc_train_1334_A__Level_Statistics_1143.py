t=int(input())

def solve(T):
    S=[]
    stats=int(input())
    for i in range(stats):
        S.append(list(map(int,input().split())))
    alert=False
    if S[0][0]<S[0][1]:
        alert=True
    for i in range(1,stats):
        if S[i][0]-S[i-1][0]<S[i][1]-S[i-1][1]:
            alert=True
            break
        if S[i][0]-S[i-1][0]<0 or S[i][1]-S[i-1][1]<0:
            alert=True
            break
        if S[i][0]<S[i][1]:
            alert=True
            break
    if alert==False:
        print("YES")
    if alert==True:
        print("NO")
for i in range(t):
    solve(i)