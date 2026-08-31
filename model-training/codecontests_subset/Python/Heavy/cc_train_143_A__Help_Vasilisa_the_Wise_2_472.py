r1,r2 = map(int,input().split())
c1,c2 = map(int,input().split())
d1,d2 = map(int,input().split())
digits = [i for i in range(1,10)]
n = 9

def good_combo(dig1,dig2,dig3,dig4):
    row1 = (r1 == dig1 + dig2)
    row2 = (r2 == dig3 + dig4)
    col1 = (c1 == dig1 + dig3)
    col2 = (c2 == dig2 + dig4)
    diag1 = (d1 == dig1 + dig4)
    diag2 = (d2 == dig2 + dig3)
    return (row1 and row2 and col1 and col2 and diag1 and diag2)
    

def solve():
    for p1 in range(n):
        for p2 in range(n):
            for p3 in range(n):
                for p4 in range(n):
                    if len(set([p1,p2,p3,p4])) == 4:
                        dig1,dig2,dig3,dig4 = digits[p1],digits[p2],digits[p3],digits[p4]
                        if good_combo(dig1,dig2,dig3,dig4):
                            print(dig1,dig2)
                            print(dig3,dig4)
                            return
    print(-1)

solve()
