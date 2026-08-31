k=int(input())
a=[[1]+[' '*(len(str(k**2))-1-len(str(i)))+str(i) for i in range(2,k)]]+[[i+1]+[0 for j in range(k-2)] for i in range(1,k-1)]
for i in range(2,k):
    for j in range(2,k):
        b=i*j
        c=''
        while b>0:
            c+=str(b%k)
            b//=k
        c=' '*(len(str(k**2))-1-len(c))+c[::-1]
        a[i-1][j-1]=c
for i in range(k-1):
    print(*a[i])