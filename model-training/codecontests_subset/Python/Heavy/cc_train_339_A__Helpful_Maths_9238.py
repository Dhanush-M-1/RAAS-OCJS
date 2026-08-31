import sys

class Scanner:

    def __init__(self):
        self.current_tokens = []

    def remaining_tokens(self):
        return len(self.current_tokens)

    def nextline(self):
        assert self.remaining_tokens() == 0, "Reading next line with remaining tokens"
        return input()

    def nexttokens(self):
        return self.nextline().split()
    
    def nexttoken(self):
        if len(self.current_tokens) == 0:
            self.current_tokens = self.nexttokens()
        assert self.remaining_tokens() > 0, "Not enough tokens to parse."
        return self.current_tokens.pop(0)

    def nextints(self, n=-1):
        if n == -1:
            return list(map(int, self.nexttokens()))
        else:
            return (self.nextint() for i in range(n))
    
    def nextint(self):
        return int(self.nexttoken())

def quit():
    sys.exit(0)

stdin = Scanner()
nextint = stdin.nextint
nextints = stdin.nextints
nextline = stdin.nextline

s = nextline().split("+")
ia = sorted([int(i) for i in s])

r = ''
for i in range(len(ia) - 1):
    r += str(ia[i])
    r += "+"
r += str(ia[len(ia) - 1])

print(r)
