def minInteger(l, r, d):
    if l > d or r < d:
        print(d)
    else :
        print((r//d + 1)*d)

def listMinInteger(q, N):
    for i in N:
        minInteger(i[0],i[1],i[2])
        
q = int(input())
N = [list(map(int , input().split())) for _ in range(q)]
listMinInteger(q,N)