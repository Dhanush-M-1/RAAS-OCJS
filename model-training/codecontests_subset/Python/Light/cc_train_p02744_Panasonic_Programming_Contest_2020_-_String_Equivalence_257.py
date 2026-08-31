N = int(input())

def f(s, mx):
    if len(s) == N:
        print(s)
    else:
        for c in range(ord('a'), ord(mx) + 1):
            f(s + chr(c), chr(ord(mx) + 1) if c == ord(mx) else mx)
    
f("", 'a')
