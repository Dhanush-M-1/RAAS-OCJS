'''
Amirhossein Alimirzaei
Telegram : @HajLorenzo
Instagram : amirhossein_alimirzaei
University of Bojnourd
'''

#print(96+(5-(96%5)))
for _ in range(int(input())):
    tmp=list(map(int,input().split()))
    if(tmp[2] not in range(tmp[0],tmp[1]+1)):
       print(tmp[2])
    else:
        print(tmp[1]+(tmp[2]-(tmp[1]%tmp[2])))