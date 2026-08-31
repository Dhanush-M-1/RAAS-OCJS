N = int(input())
inp = 'a'

def AAA(arr):
    if len(arr) < N:
        for i in range(ord(max(arr))-96+1):
            AAA(arr+chr(i+1+96))
    else:
        print(arr)


AAA(inp)