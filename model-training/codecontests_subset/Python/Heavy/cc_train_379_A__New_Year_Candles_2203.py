import sys

local_launch = False
try:
    open('LOCAL').read()
    local_launch = True
except:
    pass

input_data = open('INPUT.txt').read() if local_launch else sys.stdin.read()
done = {'i': 0}
tokens = input_data.split()

def next_token():
    result = tokens[done['i']]
    done['i'] += 1
    return result

def next_int():
    return int(next_token())

def next_str():
    return next_token()

############## BEGIN OF CODE #####################
a = next_int()
b = next_int()

candles = a
burned = 0
parts = 0

while candles > 0:
    burned += candles
    parts += candles
    candles = parts // b
    parts %= b

print(burned)









############# END OF CODE #####################