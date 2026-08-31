n,k = map(int,input().split())

A = sorted(map(int,input().split()), reverse=True)

for a in A:
  if k%a == 0:
    print(k//a)
    break