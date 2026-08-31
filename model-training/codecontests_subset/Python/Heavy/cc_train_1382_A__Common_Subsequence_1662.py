t=int(input())
for i in range(t):
    n,m=map(int,input().split())
    ln=list(map(int,input().split()))
    lm=list(map(int,input().split()))
    ans=[]
    if n==m:
        for j in range(m):
            if ln[j] in lm:
                print("YES")
                print(1,ln[j])
                break
        else:
            print("NO")
    elif m>n:
        for j in range(n):
            if ln[j] in lm:
                print("YES")
                print(1,ln[j])
                break
        else:
            print("NO")
    else:
        for j in range(m):
            if lm[j] in ln:
                print("YES")
                print(1,lm[j])
                break
        else:
            print("NO")
                
