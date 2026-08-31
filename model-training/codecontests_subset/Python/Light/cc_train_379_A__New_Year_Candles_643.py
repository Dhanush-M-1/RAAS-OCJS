candle,remake=map(int,input().split())
hours=0
ToMake=0
made=0
if candle>=remake:
    while hours<candle:
        hours+=1
        ToMake+=1
        if ToMake==remake:
            made+=1
            ToMake=0
        if candle<=hours:
            candle+=made
            made=0
print(candle)