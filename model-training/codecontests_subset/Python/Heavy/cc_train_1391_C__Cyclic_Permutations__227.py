class BigMod(object):
    __mod = None
    def __init__(self, mod = 1000000007):
        self.__mod = mod
        
    def big_mod(self, base, pw):
        if pw == 0:
            return 1
        r = self.big_mod(base, pw//2)
        r = (r * r) % self.__mod
        if pw % 2 :
            r = (base * r) % self.__mod
        #print(f"return value --> {r}")
        return r       
            
def solve():
    n = int(input())
    sol = BigMod()
    bad = sol.big_mod(2, n-1)
    fact = 1
    for i in range(1 , n+1):
        fact *= i
        fact %= 1000000007
    res = ( (fact-bad) + 1000000007) % 1000000007
    print(res)
    
if __name__ == '__main__':
    solve()