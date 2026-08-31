N=int(input())
def f(l,m,n):
    if n==N:
        print(''.join([chr(ord('a')+i) for i in l]))
    else:
        for i in range(m+2):
            f(l+[i],max(m,i),n+1)
f([0],0,1)