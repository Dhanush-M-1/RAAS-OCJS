a,b=map(int,input().split())
z=a
cand=a

while z>=b:
    e = z % b

    z=z//b
    cand+=z
    z += e


print(cand)
