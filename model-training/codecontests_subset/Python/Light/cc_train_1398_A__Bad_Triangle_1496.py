t=int(input())
for q in range(t):
    n=int(input())
    ch=input()
    L=[int(i)for i in ch.split()]
    if L[0]+L[1]<=L[-1]:
        print(1,2,n)
    else:
        print(-1)
    
