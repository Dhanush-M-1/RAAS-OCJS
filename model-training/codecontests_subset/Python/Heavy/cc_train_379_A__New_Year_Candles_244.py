# n = int(input())
# a = [1]
# for i in range(n):
#     print(*a)
#     a = [1] + [a[j] + a[j + 1] for j in range(i)] + [1]

#a = 1
#n = int(input())
#for i in range(2, n):
#    if n % i == 0:
#        a = 0
#        break
#if a == 0:
#    print("I am way to dumb to get an answer correctly")
#    print("NO")
#else:
#    print("YES")
#    print("I am way to dumb to get an answer correctly")

#a = [int (x) for x in input().split()]
#for i in range(len(a) - 1 , -1, -1):
#    print(a[i], end = " ")


#a = [int (x) for x in input().split()]
#if len(a) % 2 == 0 :
#    for i in range (len(a) // 2 -1, -1, -1):
#        print(a[i], end = " ")
#    for j in range (len(a)//2, len(a)):
#        print(a[j], end = " ")
#else:
#    for i in range (len(a) // 2, -1, -1):
#        print(a[i], end = " ")
#    for j in range (len(a)//2, len(a)):
#        print(a[j], end = " ")

#b = []
#c = []
#a = [int (x) for x in input().split()]
#for i in range(len(a)):
#    if i % 2 == 0:
#        b.append (a[i])
#    else:
#        c.append (a[i])
#c.reverse()
#print(*b, end = " ")
#print(*c, end = " ")




#b = 1
#n = int(input())
#a = [int(x) for x in input().split()]
#for i in range(len(a)):
#    if a[i] == n:
#        b = 0
#        break
#if b == 0:
#    print( i + 1 , sep="\n")
#else:
#    print(-1)




#left = 0
#k = int(input())
#a = [int(x) for x in input().split()]
#right = len(a)
#while right - left > 1:
#    middle = (right + left) // 2
#    if k < a[middle]:
#        right = middle
#    else:
#        left = middle
#if a[left] == k:
#    print(left + 1)
#else:
#    print(-1)

#a = input()
#for i in range(0, len(a)):
#    if (i + 1) % 3 != 0:
#        print(a[i], end = " ")
#a = input()

#for i in range(0, len(a)):
#    if (i + 1) % 3 == 0 or (i + 1) % 2 == 0:
#        print(a[i], end = " ")


#print([int(elem) for i, elem in enumerate(input().split()) if i % 3 != 0])

#class Cat:
#    def __init__(self, face, paws, whiskers, belly, what_they_like, pawsonality):
#        self.face = face
#        self.paws = paws
#        self.whiskers = whiskers
#        self.belly = belly
#        self.what_they_like = what_they_like
#        self.pawsonality = pawsonality
#    def __str__(self):
#        return "face: {}\npaws: {}".format( self.face, self.paws, self.whiskers, self.belly, self.what_they_like, self.pawsonality)
#Tyson = Cat(1, 4, 18, 3.5, ["water", "food", "ropes", "blankets"], "playful, stubborn, sleepy")
#print(Tyson)

#a = list(input())
#b = list(reversed(a))
#if a == b:
#    print("YES")
#else:
#    print("NO")

#meow

#countmeow = 0
#a = list(input())
#b = list(reversed(a))
#for i in range(len(a)):
#    if a[i] != b[i]:
#        countmeow = countmeow + 1
#if countmeow == 0 and len(a) % 2 != 0:
#    print("YES")
#elif countmeow == 2:
#    print("YES")
#else:
#    print("NO")

#input()
#letmeowchange = 0
#num = input()
#a = dict()
#if len(num) > 26:
#    print(-1)
#else:
#    for letter in num:
#        if letter in a:
#            a[letter] += 1
#        else:
#            a[letter] = 1
#    for letter in a:
#        letmeowchange += a[letter]-1
#    print(letmeowchange)

#print(round(sum([float(i) for i in input().split()]), 1))


#a = [int(i) for i in input().split()]
#b = [int(j) for j in input().split()]
#for i in zip(b, a):
#    print(*i, end = " ")

#print([int(-i) if i%2==0 else int(i) for i in range(1,int(input()) + 1)])

#cb = input()
#bc = [int(i) for i in input().split()]
#a = {elem1: elem2 for elem1, elem2 in zip(cb, bc)}
#print(a)


#b = 0
#for i in range(10, 100):
#    if i % 5 != 0 and i % 7 != 0:
#        b = b + 1
#print(b)

#a = int(input())
#b = " that I hate"
#c = " that I love"
#print("I hate", end = "")
#for i in range(a - 1):
#    if i % 2 == 0:
#       print(c, end = "")
#    else:
#        print(b, end = "")
#print(" it")

#a = int(input())
#b = [int(input()) for i in range(a)]
#c = b[0]
#d = 0
#for i in b[1::]:
#    if i != c:
#        d = d + 1
#        c = i
#print(d + 1)

#input()
#letmeowchange = 0
#num = input()
#a = dict()
#if len(num) > 26:
#    print(-1)
#else:
#    for letter in num:
#        if letter in a:
#            a[letter] += 1
#        else:
#            a[letter] = 1
#    for letter in a:
#        letmeowchange += a[letter]-1
#    print(letmeowchange)

#from math import ceil
#a = int(input())
#b = [int(i) for i in input().split()]
#c = sum(b)
#
#d = {1:0, 2:0, 3:0, 4:0}
#total = 0
#r2 = 0
#for i in b:
#    if i in d:
#        d[i] += 1
#    else:
# d[i] = 1
#total = total + d[4]
#total = total + d[3]
#total = total + (d[2] // 2)
#r2 = d[2] % 2
#if r2 != 0:
#    d[1] = d[1] - 2
#    total = total + 1
#if d[1] > d[3]:
#    total += ceil((d[1] - d[3]) / 4)
#print(total)

#n = int(input())
#a = [int(i) for i in input().split()]
#print(*sorted(a))

#s = list(input())
#t = list(input())
#a = list(reversed(s))
#if t == a:
#    print("YES")
#else:
#    print("NO")

#a = input().split()
#b = 0
#c = 0
#d = dict()
#for letter in a:
#    if letter in d:
#        d[letter] += 1
#    else:
#       d[letter] = 1
#for value in d.values():
#    if value % 2 != 0:
#        c = c + 1
#if c > 1:
#    print("NO")
#else:
#    print("YES")


#n = input()
#a = [int(i) for i in n]
#b = 0
#for i in a:
#    if i == 4 or i == 7:
#        b = b + 1
#if b == 4 or b == 7:
#    print("YES")
#else:
#    print("NO")


#n = input()
#a = [int(i) for i in n]

#b = 0
#c = 0
#a = "abcdefgthijklmnopqrstuvwxyz"
#s = input()
#for i in s:
#    if i in a:
#        b = b + 1
#    else:
#c = c + 1
#if b == c or b > c:
#    print(s.lower())
#else:
#    print(s.upper())



#b = 0
#k = int(input())
#l = int(input())
#m = int(input())
#n = int(input())
#d = int(input())
#for i in range(1, d + 1):
#    if i % k == 0:
#       b = b + 1
#   elif i % l == 0:
#       b = b + 1
#   elif i % m == 0:
#       b = b + 1
#   elif i % n == 0:
#       b = b + 1
#print(b)


#a = input().split("WUB")
#for i in a:
#    if i != '':
#        print(i , end = " ")


#n, m = [int(i) for i in input().split()]
#f = [int(i) for i in input().split()]
#a = sorted(f)
#A = 0
#B = 0
#answer = 999999999999999999
#c = 3
#for i in range (0, len(a) - n + 1):
#    A = a[i]
#    B = a[i + n - 1]
#    if B - A < answer:
#        answer = B - A
#print(answer)

#s = [int(i) for i in input().split()]
#s = set(s)
#print(4 - len(s))

#n = int(input())
#a = [int(i) for i in input().split()]
#b = -9999999999999999999999999999
#c = 9999999999999999999999999999
#d = 0
#f = 0
#naswer = 0
#index = 0
#for i in range(len(a)):
#    if a[i] > b:
#        d = i
#        b = a[i]
#    if a[i] <= c:
#        f = i
#        c = a[i]
#index = len(a) - 1
#naswer = naswer + (index - f)
#naswer = naswer + d
#if f < d:
#    naswer = naswer - 1
#print(naswer)

#t = int(input())
#naswer = 0
#for i in range (t):
#    n = int(input())
#    naswer = n // 2
#    print(naswer)

#n, k = [int(i) for i in input().split()]
#naswer = 0
#if k <= (n + (n % 2)) // 2:
#    naswer = k * 2 - 1
#else:
#    naswer = (k - (n + (n % 2)) // 2) * 2
#print(naswer)

#n = int(input())
#a = [int(i) for i in input().split()] + [9999999999]
#for i in range(n):

#d = 0
#n = int(input())
#p = [int(i) for i in input().split()]
#q = [int(i) for i in input().split()]
#a = []
#for i in range(1, len(p)):
#    a.append(p[i])
#for j in range(1, len(q)):
#    a.append(q[j])
#b = set(a)
#for i in range(1, n + 1):
#    if i in b:
#        d = d + 1
#if d == n:
#    print("I become the guy.")
#else:
#    print("Oh, my keyboard!")


#n = int(input())
#a = [i for i in input().lower()]
#b = set(a)
#if len(b)>=26:
#    print("YES")
#else:
#    print("NO")


#n = int(input())
#a = {"Icosahedron" : 20, "Dodecahedron" : 12, "Octahedron" : 8, "Cube" : 6, "Tetrahedron" : 4}
#b = 0
#for i in range(n):
#    c = input()
#    b = b + a[c]
#print(b)


#a = input()
#b = input()
#c = input()
#d = dict()
#e = dict()
#for i in a:
#    if i in d:
#        d[i] = d[i] + 1
#    else:
#        d[i] = 1
#for i in b:
#    if i in d:
#        d[i] = d[i] + 1
#    else:
#        d[i] = 1
#for i in c:
#    if i in e:
#        e[i] = e[i] + 1
#    else:
#        e[i] = 1
#if  d == e:
#    print("YES")
#else:
#    print("NO")#


#n, m = [int(i) for i in input().split()]
#b = min(n, m)
#if b % 2 !=0:
#    print("Akshat")
#else:
#    print("Malvika")
#
#n, m = [int(i) for i in input().split()]
#ho = "#"
#hi = "."
#for i in range(1, n  + 1):
#    if i % 4 != 0 and i % 2 == 0:
#        print(hi*(m-1) + ho)
#    elif i % 4 == 0:
#        print(ho + hi* (m - 1))
#    else:
#        print(ho * m)

#n, m = [int(i) for i in input().split()]
#a = [int(i) for i in input().split()]
#hosss = 1
#besss = 0
#for i in a:
#    if (i >= hosss):
#        besss = besss + (i - hosss)
#    else:(
#        besss = besss + (n - hosss + i)
#    hosss = i
#print(besss)


#n = int(input())
#x = [int(i) for i in input().split()]
#q = int(input())
#x.sort()
#for i in range(q):
#    k = int(input())
#    l = -1
#    r = n
#    while (r - l > 1):
#        middle = l + (r - l) // 2
#        if x[middle] <= k:
#            l = middle
#        else:
#            r = middle
#    print( l + 1 )

#a, b = [int(i) for i in input().split()]
#c = min(a, b)
#d = max(a, b)
#e = d - c
#print(c, e//2)


#k, r = [int(i) for i in input().split()]
#for i in range(1, 11):
#    if ((k * i) - r) % 10 == 0:
#        print(i)
#        break
#    if (k * i) % 10 == 0:
#        print(i)
#        break


#n = int(input())
#a = [int(i) for i in input().split()]
#m = int(input())
#q  = [int(i) for i in input().split()]
#b = [a[0]]
#for i in range(1, len(a)):
#    b.append(a[i] + b [i - 1])
#for i in range(len(q)):
#    l = -1
#    r = len(a)
#    while (r - l > 1):
#        mid = (l + r) // 2
#        if b[mid] < q[i]:
#            l = mid
#        else:
#            r = mid
#    print(r + 1)


#n, t = [int(i) for i in input().split()]
#a = [0] + [int(i) for i in input().split()]
#b = []
#naswer = 0
#noswer = 0
#nul = 0
#for i in a:
#    nul = nul + i
#    b.append(nul)
#for i in range(1, n + 1):
#    l = i - 1
#    r = n + 1
#    while(r - l > 1):
#        mid = (l + r) // 2
#        noswer = b[mid] - b[i - 1]
#        if (noswer) <= t:
#            l = mid
#        else:
#            r = mid
#    naswer = max(naswer, l - i + 1)
#print(naswer)

#n, m, a, b = [int (i) for i in input().split()]
#if m * a <= b:
#    print(n * a)
#else:
#    c = n % m
#    if c == 0:
#        print((n//m) * b)
#    if c != 0:
#        d = a * c
#        if d > b:
#            print(b + ((n//m) * b))
#        else:
#            print(d + ((n//m) * b))

a, b = [int (i) for i in input().split()]
naswer = 0
c = 0
while a > 0:
    naswer = naswer + a
    c = c + a
    a = c // b
    c = c % b
print(naswer)