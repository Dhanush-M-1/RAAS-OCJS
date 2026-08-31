def main():
    t = int(input())
    for __ in range(t):
        l,r,d = map(int,input().split())
        if l//d >= 1 and l !=  d:
            print(d)
        
        else:
            print(((r//d)+1)*d)
if __name__ == '__main__':
    main()
