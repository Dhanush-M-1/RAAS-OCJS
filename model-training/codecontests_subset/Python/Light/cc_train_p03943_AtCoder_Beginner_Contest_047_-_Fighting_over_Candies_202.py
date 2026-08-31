l=list(map(int,input().split()))
l.sort()

print("YNeos"[l[0]+l[1]!=l[2]::2])
