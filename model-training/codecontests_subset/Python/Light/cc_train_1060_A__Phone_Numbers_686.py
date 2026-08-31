def read():
    return int(input())

def read_cards():
    s = input()
    return list(int(e) for e in s)
    
n = read()
arr = read_cards()

print(min(len(arr) // 11, arr.count(8)))