def non_degenerate(t, N):
    for k in range(2, N):
        if t[0]+t[1] <= t[k]:
            return str(1)+" "+ str(2)+" "+str(k+1)
    return -1
I=input
for _ in range(int(I())):
    I()
    t= list(map(int,I().split()))
    print(non_degenerate(t, len(t)))