# a,b,c = (map(int, input().split()))

# n = int(input())
# while n > 0 :
#     l = list(map(int, input().split()))
#     for i in l:
#         print(l[i])
#     n -= 1

'''
n,k = [int(x) for x in input().split()]
l = []
for i in range(n):
    x = int(input())
    l.append(x)

print (l)
'''

'''
s = str(input())
v = [ 'a' , 'e' , 'i' , 'o' , 'u' , 'A' , 'E' , 'I' , 'O' , 'U' , 'y' , 'Y' ]
d = []
for i in s:
    d.append(i.lower())

s1 = ''

for i in d:
    if(i in v):
        continue
    else:
        s1 = s1 + '.' + str(i)
print(s1)
'''

s = str(input())
l = s.split('+')
l.sort()
for i in range(len(l)):
    # print(int(i))
    if(i < len(l)-1):
        print( l[int(i)] + '+' , end = '')
    elif(i == len(l)-1):
        print(l[int(i)])

