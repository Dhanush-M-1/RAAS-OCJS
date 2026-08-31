a,b=map(int,input().split())
candles=a
leftout=a
while(leftout>=b):
    candles+=(leftout)//b
    leftout=(leftout)%b+(leftout)//b
print(candles)