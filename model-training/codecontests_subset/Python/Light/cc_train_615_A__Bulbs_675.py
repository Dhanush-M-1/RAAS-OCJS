n,k=map(int,input().split());s={i for i in range(1,k+1)}
for case in " "*n:s=s.difference(set(list((map(int,input().split())))[1:]))
print("YES" if len(s)==0 else "NO")