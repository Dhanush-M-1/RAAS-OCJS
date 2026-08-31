n,m=[int(x) for x in input().split()]
b=[]
for i in range(m):
    b.append("OFF")
for j in range(n):
    o=[int(x) for x in input().split()]
    for k in range(1,o[0]+1):
        if b[o[k]-1]=="OFF":
            b[o[k]-1]="ON"
print("YES" if b.count("OFF")==0 else "NO")