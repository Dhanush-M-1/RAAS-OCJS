n,k = input().strip().split(' ')
n,k = [int(n),int(k)]
l = list(map(int, input().strip().split(' ')))

while True :
    if k % max(l) == 0:
        print (k // max(l))
        break
    else:
        l.remove(max(l))
