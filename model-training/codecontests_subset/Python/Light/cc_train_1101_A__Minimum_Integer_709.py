T = int(input())
for t in range(T):
    l,r,d = [int(x) for x in input().split()]
    if d<l or d>r :
        print(d)
    else:
        remainder = (r+1)%d
        addend = d - remainder if remainder!= 0 else 0
        
        print(r+1+addend if remainder!= 0 else r+1)