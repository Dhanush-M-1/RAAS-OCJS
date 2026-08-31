from sys import stdin,stdout

if __name__ == '__main__':
    n,k=map(int,stdin.readline().split())
    a=list(map(int,stdin.readline().split()))
    ans=200000
    for x in range(0,200001):
        cnt=0
        b=[]
        for V in a:
            v=V
            num=0
            while v>x:
                v//=2
                num+=1
            if v!=x:
                num=200000
            b.append(num)
        b.sort()
        for i in range(k):
            cnt+=b[i]
        ans=min(ans,cnt)
    stdout.write('%d\n'%(ans))




