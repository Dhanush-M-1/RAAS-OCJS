N=int(input())

l=["a"]

a=ord("a")

for i in range(N-1):
    la=[]
    for j in l:
        b=ord(max(j))
        for k in range(a,b+2):
            la.append(j+chr(k))
    l=la

for i in l:
    print(i)