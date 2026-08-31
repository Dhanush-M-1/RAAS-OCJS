def mp():  return map(int,input().split())
def lt():  return list(map(int,input().split()))
def pt(x):  print(x)
def ip():  return input()
def it():  return int(input())
def sl(x):  return [t for t in x]
def spl(x): return x.split()
def aj(liste, item): liste.append(item)
def bin(x):  return "{0:b}".format(x)
def listring(l): return ' '.join([str(x) for x in l])
def printlist(l): print(' '.join([str(x) for x in l]))

a = input().split()
n = int(a[-1])
if n*(a.count("+")+1) - a.count("-") < n:
    print("Impossible")
else:
    b = [x for x in a if x == "+" or x == "-"]
    b.insert(0,"+")
    c = [n if b[i] == "+" else 1 for i in range(len(b))]
    x = n*(a.count("+")+1) - a.count("-") - n
    j = 0
    while x > 0 and j < len(c):
        if x >= n-1:
            if c[j] == n:
                c[j] -= (n-1)
            else:
                c[j] += (n-1)
            x -= (n-1)
        else:
            if c[j] == n:
                c[j] -= x
            else:
                c[j] += x
            x = 0
        j += 1
    if x != 0:
        print("Impossible")
        exit()
    print("Possible")
    result = ""
    b.pop(0)
    for i in range(len(b)):
        result += str(c[i])
        result += " "
        result += b[i]
        result += " "
    result += ("%d " % c[-1])
    result += ("= %d " % n)
    print(result)
