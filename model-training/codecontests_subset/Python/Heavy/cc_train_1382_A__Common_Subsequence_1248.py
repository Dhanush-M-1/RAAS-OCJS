'''Author: Pranit Bhujel'''
ls = lambda : list(map(int, input().split()))
ip = lambda : int(input())
r = lambda a : range(a)

'''imports if any'''


'''showtime'''
if __name__=="__main__":
    t = ip()
    for _ in r(t):
        m, n = ls()
        arr_m = ls()
        arr_n = ls()
        
        sm = set(arr_m)
        sn = set(arr_n)
        
        p = False
        for i in sm:
            if i in sn:
                p = True
                print("YES")
                print("1 " + str(i))
                break
        if not p:
            print("NO")
