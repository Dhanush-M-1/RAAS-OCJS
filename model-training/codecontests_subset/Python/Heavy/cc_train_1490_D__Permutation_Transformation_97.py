import sys
input=sys.stdin.readline

def tree(a,base):
    if len(a)==0:
        return
    if len(a)==1:
        return [base]
    
    temp=a.index(max(a))
    ans=[base for x in range(len(a))]

    temp1=tree(a[:temp],base+1)
    temp2=tree(a[temp+1:],base+1)
    temp=0

    if temp1:
        for i in temp1:
            ans[temp]=i
            temp+=1
    temp+=1
    if temp2:
        for i in temp2:
            ans[temp]=i
            temp+=1

    return ans


t = int(input())

for i in range(t):
    n=int(input())
    a=[int(x) for x in input().split()]
    base=0
    
    ans = tree(a,0)
    ans = [str(i) for i in ans]

    print(' '.join(ans))