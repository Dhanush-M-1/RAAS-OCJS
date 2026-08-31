from sys import stdin, stdout
from collections import Counter

intn = lambda : int(stdin.readline())
strs = lambda : stdin.readline()[:-1]
lstr = lambda : list(stdin.readline()[:-1])
mint = lambda : map(int, stdin.readline().split())
lint = lambda : list(map(int, stdin.readline().split()))
out = lambda x: stdout.write(str(x)+"\n")
out_ = lambda x: stdout.write(str(x)+' ')

def main():
    k = intn()
    s = lstr()
    if k==1:
       out(''.join(s))
    elif len(s)%k!=0:
        out(-1)
    else:
        c = Counter(s)
        for i in c.keys():
            if c[i]%k!=0:
                out(-1)
                break
        else:
            ans = []
            for i, e in c.items():
                ans.append(i*(e//k))
            out(''.join(ans)*k)

if __name__ == "__main__":
    main()