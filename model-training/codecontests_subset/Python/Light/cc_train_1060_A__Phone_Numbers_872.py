n = int(input())
s = input()
eight = s.count("8")
if eight == n:
    ans=eight//11
    print(ans)
else:
    all_except_eight = n-eight
    tmp = all_except_eight//10
    remaining=all_except_eight%10
    ans=0
    if eight>=tmp:
        ans=tmp
        eight-=tmp
        if eight==0:
            print(ans)
        else:
            if remaining+eight>=11:
                ans+=1
            eight-=(11-remaining)
            if eight>=0:
                ans+=eight//11
            print(ans)
    else:
        print(eight)