candle,k=tuple(map(int,input().split()))

ans=0
rem=0

while(candle!=0):
    ans+=candle

    new_candle=(candle+rem)//k
    rem=(candle+rem)%k

    candle=new_candle

print(ans)