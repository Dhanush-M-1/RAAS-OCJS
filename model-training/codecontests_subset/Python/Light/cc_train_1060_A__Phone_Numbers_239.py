'''
Amirhossein Alimirzaei
Telegram : @HajLorenzo
Instagram : amirhossein_alimirzaei
University of Bojnourd
'''

N=int(input())
CART=list(input())
C=0
if "8" not in CART:
    print(0)
else:
    X=N//11
    print(X if CART.count("8")>=X else CART.count("8"))