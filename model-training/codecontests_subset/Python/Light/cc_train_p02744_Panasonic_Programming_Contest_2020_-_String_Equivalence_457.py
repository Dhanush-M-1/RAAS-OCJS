N=int(input())
def struct(s,i,n,ma):
    if i==n:
        print(s)
    else:
        for j in range(0,ma+2):
            struct(s+chr(ord('a')+j),i+1,n,max(j,ma))
struct('a',1,N,0)