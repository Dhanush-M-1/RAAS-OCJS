from sys import stdin, stdout

class SOLVE:
    def solve(self):
        R = stdin.readline
        #f = open('input.txt');R = f.readline
        W = stdout.write
        
        ans = []
        
        for i in range(int(R())):
            n = int(R())
            
            two = 0
            while not n%2:
                two += 1
                n  //= 2
                
            three = 0
            while not n%3:
                three += 1
                n    //= 3
                
            if n != 1 or three < two:
                ans.append('-1')
                continue
                
            ans.append(str(max(two, three) + three - two))
        
        W('\n'.join(ans))
        
def main():
    s = SOLVE()
    s.solve()
main()