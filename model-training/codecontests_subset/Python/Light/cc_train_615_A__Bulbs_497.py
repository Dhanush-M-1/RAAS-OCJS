n,m=map(int,input().split())
bulbOn=[False]*m
for i in range(n):
    turnedOn=list(map(int,input().split()))
    if turnedOn[0]!=0:
        for j in turnedOn[1:]:
            bulbOn[j-1]=True
print("YES" if bulbOn==[True]*m else "NO")