n=int(input())
s=input()
if n<5:
    print("no")
else:
    for l in range(1,n-3):
        ans=0
        for st in range(n):
            fl=0
            if s[st]=='.':
                continue
            else:
                cn=0
                for j in range(st+l,n,l):
                    if s[j]=='.':
                        fl=1
                        cn=-1
                    else:
                        cn+=1
                        if cn==4:
                            fl=3
                            break
            if fl==3:
                ans=1
                break
        if ans==1:
            break
    if ans==1:
        print("yes")
    else:
        print("no")