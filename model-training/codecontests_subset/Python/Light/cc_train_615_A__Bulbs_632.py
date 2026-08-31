import sys


class Bulb:
    def __init__(self, n):
        self.set = set(range(1, n+1))

    def insert(self, bulbs):
        for n in bulbs:
            if n in self.set:
                self.set.remove(n)

    def get(self):
        if len(self.set) == 0:
            print("YES")
        else:
            print("NO")

def main():
    button, bulbs = [int(x) for x in sys.stdin.readline().split()]
    test = Bulb(bulbs)
    for i in range(button):
        arr = [ int(x) for x in sys.stdin.readline().split()]
        test.insert(arr[1::])
    test.get()


if __name__ == "__main__":
    main()
