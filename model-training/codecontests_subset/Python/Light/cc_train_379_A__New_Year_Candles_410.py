a,b=input().split()
a=int(a)
b=int(b)
total_hours_left=a
hours_burned=0
burned_candles=0
while total_hours_left>0:
    hours_burned+=1
    total_hours_left-=1
    burned_candles+=1
    if burned_candles==b:
        total_hours_left+=1
        burned_candles=0
print(hours_burned)
