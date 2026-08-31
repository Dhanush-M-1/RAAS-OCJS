import math
class data:
    def __init__(self):
        a,b,c = map(int, input().split())
        self.n = a
        self.x = b
        self.y = c
        self.printit()
    def claculate(self):
        p = self.y/100;
        p = p*self.n 
        p = math.ceil(p)
        p = int(p)
        p = p - self.x 
        if p<0:
            p = 0
        return p 
    def printit(self):        
        print(self.claculate())



inp = data()
