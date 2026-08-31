a,b=map(int,input().split())
c=set()
for i in range(a):
        d,*e=map(int,input().split())
        c|=set(e)
print('YES'if len(c)==b else'NO')
