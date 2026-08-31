
def solver(candles:int, to_reproduce:int):
    count = 0
    while candles >= to_reproduce:
        candles = candles - to_reproduce + 1
        count+= 1
    return count

st = input()
list = [int(s) for s in st.split() if s.isdigit()]
candles = list[0]
to_reproduce = list[1]
if candles >= to_reproduce:
    print(solver(candles, to_reproduce) + candles)
else:
    print(candles)