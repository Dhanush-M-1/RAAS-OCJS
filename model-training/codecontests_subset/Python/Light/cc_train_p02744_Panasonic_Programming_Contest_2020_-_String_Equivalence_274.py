n = int(input())
s = 'a'

def func(s, count, cc):
    if count == n:
        print(s)
        return
    for i in range(min(count, cc) + 1):
        func(s + chr(ord('a') + i), count + 1, max(i+1, cc))

func(s, 1, 1)