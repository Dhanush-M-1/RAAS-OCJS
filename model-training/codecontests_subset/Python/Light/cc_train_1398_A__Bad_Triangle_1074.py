t = int(input())
for _ in range(t):
    n = int(input())
    s = list(map(int,input().split()))
    i=0
    j=1
    k=-1
    z=j+1
    while z<n:
        if s[i]+s[j]<=s[z]:
            k=z
            break
        else:
            z+=1
            
    if k==-1:
        print(k)
    else:
        print(str(i+1)+" "+str(j+1)+" "+str(k+1))