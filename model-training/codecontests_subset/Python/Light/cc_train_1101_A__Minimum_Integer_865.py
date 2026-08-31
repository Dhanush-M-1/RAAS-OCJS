q=int(input())
result=[]
for i in range(q):
    l,r,d=map(int,input().split())
    if l//d>1 and l%d==0:
        result.append(str(d))
    elif l//d>=1 and l%d!=0:
        result.append(str(d))
    else:
        result.append(str((r//d+1)*d))
print('\n'.join(result))
