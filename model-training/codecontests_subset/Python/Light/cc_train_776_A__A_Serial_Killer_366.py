name=list(input().split())
print(name[0]+" "+name[1])
t=int(input().strip())
for i in range(t):
    next=list(input().split())
    if name[0]==next[0]:
        name[0]=next[1]
    else:
        name[1]=next[1]
    print(name[0]+" "+name[1])