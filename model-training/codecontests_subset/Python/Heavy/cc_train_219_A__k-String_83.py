from sys import stdin, stdout, stderr, setrecursionlimit
setrecursionlimit(100000)

def debug (*e):
    if not __debug__:
        print(*e, file=stderr)

def dd(*vals):
    import inspect, re
    frame = inspect.getframeinfo(inspect.stack()[1][0])
    vs = re.search("dd\((.+)\)", frame.code_context[0]).group(1).split(",")
    if vs:
        debug(",".join("{0} = {1}".format(vs[i], v) for i,v in enumerate(vals)))

def trace(f):
    def traced(*args, **kw):
        debug("calling {} with args {}, {}".format(f.__name__, args, kw))
        return f(*args, **kw)
    return traced
#@trace
#def f(x):

def read():
    return stdin.readline().rstrip()

def readarr(sep=None, maxsplit=-1):
    return read().split(sep, maxsplit)

def readint():
    return int(read())

def readia(sep=None, maxsplit=-1):
    return [int(a) for a in readarr(sep, maxsplit)]

#write(1, 2, 3, sep="-", end="!")
def write(*args, **kwargs):
    sep = kwargs.get('sep', ' ')
    end = kwargs.get('end', '\n')
    stdout.write(sep.join(str(a) for a in args) + end)

#writea([1, 2, 3], sep="-", end="!")
def writea(arr, sep=' ', end='\n'):
    stdout.write(sep.join(str(a) for a in arr) + end)

from collections import Counter



#N = 5
#s = "aaaaa"

#N = 7
#s = "abacaba"

#N = 2
#s = "aazz"

N = 5
s = "czhlahbrbkdmwfhmrbdktmdawpmajfpwqznaqlhibabqhyzabxqfbhkokadqycjvdjtjjrdfggbjujfgxtqejklgxflqbqpyekiterwzkmflybhtjhpxwnjtgqaykaaalxfkcylhnhthauplhmlvylpztjimlmjuffljfmqufxwmwvplgmjaxoaalhmftyhujtdoybaipffhgoqugfatgzaahwraykvifwytmpgakhfmyqidofzahzfnokhihhooyaypzegafxuuaeyatodgmywwzhlguwjqdlofahlbhkjoegamitaaayqeehxihjpxbidjychwmtgybaubeagfgqqmclkxthzzhjlfoxvyhatwqabmewjkhhyalplmmjomxndwbmwwqwdwgbyhikpkijbhtafuxgoiuijbaafyojhalulpmfjhomeoajdtytluhwdtgzifgflfkjhoewaeeottgjakjwggqgewtzwahytqkhuxoapz"

N = readint()
s = read()

if len(s)%N != 0:
    write(-1)
    exit(0)

g = len(s) // N

cant = Counter(s)
d = {l:c//N for l,c in cant.items()}

r = []
for l,c in d.items():
    x = c, cant[l]/g, N
    if c==0 or cant[l]/N != c:
        r = -1
        break
    r.append(l*int(c))
else:
    r = "".join(r) * N
    #r = "".join(sorted(r)) * N

write(r)
