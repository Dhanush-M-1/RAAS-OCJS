import sys

class Candles():
    def __init__(self,original,renew):
        self.light = original;
        while original >= renew :
            original -= renew
            self.light += 1
            original += 1

    def getLight(self):
        return self.light

def main():
    a, b = [ int(x) for x in sys.stdin.readline().strip().split() ]
    vasily = Candles(a, b)
    print(vasily.getLight())

if __name__ == ("__main__"):
    main()
