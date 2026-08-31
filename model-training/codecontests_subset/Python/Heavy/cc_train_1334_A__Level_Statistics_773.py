import sys
input = sys.stdin.readline
############ ---- Input Functions ---- ############
def inp(): # read integer input
    return(int(input()))
def inlt(): # read list integer input
    return(list(map(int,input().split())))
def insr(): # read list of chars
    s = input()
    return(list(s[:len(s) - 1]))
def invr(): # space seperated intefer inputs
    return(map(int,input().split()))
def bool_to_str(flag):
    if flag:
        return "YES"
    else:
        return "NO"
test_cases = inp()
for test in range(test_cases):
    peaks = inp()
    last_plays = 0
    last_clears = 0
    valid = True
    for peak in range(peaks):
        current_pair = inlt()
        if current_pair[0] < last_plays:
            valid = False
        if current_pair[1] < last_clears:
            valid = False
        if (current_pair[1] - last_clears) > (current_pair[0] - last_plays):
            valid = False
        if current_pair[1] > current_pair[0]:
            valid = False
        last_plays = current_pair[0]
        last_clears = current_pair[1]
    print(bool_to_str(valid))
