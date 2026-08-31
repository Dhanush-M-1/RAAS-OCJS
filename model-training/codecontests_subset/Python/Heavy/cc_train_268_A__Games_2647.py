import sys

class soccerColor():
    def __init__(self):
        self.home = []
        self.away = dict([])

    def addColor(self, h, a):
        self.home.append(h)
        if a in self.away:
            self.away[a] += 1
        else:
            self.away[a] = 1

    def calculate(self):
        count = 0
        for h in self.home:
            if h in self.away:
                count += self.away[h]
        return count

def main():
    teams = int(sys.stdin.readline().strip())
    champion = soccerColor()
    for i in range(teams):
        h, a = [int(x) for x in sys.stdin.readline().strip().split()]
        champion.addColor(h,a)
    print(champion.calculate())
    
if __name__ == ("__main__"):
    main()
