a,b=map(int,input().split());i=1;x=0
curra=a;currb=0
while curra!=0:
    x+=curra
    currb+=curra
    curra=currb//b
    currb=currb%b
print(x)