n,m=map(int,input().split())
bulbOn=[]
for i in range(n):
    turnedOn=list(map(int,input().split()))
    if turnedOn[0]!=0:
        for j in turnedOn[1:]:
            if j not in bulbOn:
                bulbOn.append(j)
print("YES" if len(bulbOn)==m else "NO")