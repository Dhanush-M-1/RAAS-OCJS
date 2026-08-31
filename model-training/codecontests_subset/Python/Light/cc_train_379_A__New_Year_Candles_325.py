lines = input()
lines = lines.split(" ")
a = int(lines[0])
b = int(lines[1])
hours = 0
def new_candles(n,b,hours):
    undone_candles = n
    while (n>=b):
        full_candles = int(n/b)
        undone_candles = int(n%b)
        hours = hours + full_candles
        n = full_candles + undone_candles
        #print("n is {} full is {} undone is {} b is {}".format(n,full_candles,undone_candles,b))
    return hours
hours = a + new_candles(a,b,hours)  
print(int(hours))