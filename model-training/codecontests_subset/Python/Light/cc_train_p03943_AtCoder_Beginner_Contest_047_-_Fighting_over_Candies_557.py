N = list(map(int,input().split()))
N.sort()
print("Yes" if N[2]==(N[0]+N[1]) else "No")