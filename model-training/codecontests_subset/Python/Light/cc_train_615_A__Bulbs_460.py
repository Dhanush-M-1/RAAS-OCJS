'''
Amirhossein Alimirzaei
Telegram : @HajLorenzo
Instagram : amirhossein_alimirzaei
University of Bojnourd
'''

n=list(map(int,input().split()))
blb=[]
for _ in range(n[0]):
    tmp=(list(map(int,input().split())))
    for __ in tmp[1:]:
        if __ not in blb:
            blb.append(__)
print("YES" if len(blb)==n[1] else "NO")

