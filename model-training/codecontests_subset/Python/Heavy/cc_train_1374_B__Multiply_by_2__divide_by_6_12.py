t = int(input())

def count_3(n):
    counter = 0
    while n%3 ==0:
        #print(n,counter)
        counter+=1
        n=n/3
    return counter
def count_2(n):
    counter = 0
    while n%2 ==0:
        #print(n,counter)
        counter+=1
        n=n/2
    return counter

        
for i in range(t):
    n = int(input())
    c3 = count_3(n)
    c2 = count_2(n)
    #print(c2,c3)
    r = n
    #print('r1',r)
    if c3>0:
        r = r/(3**c3)
    #print('r2',r)
    if c2>0:
        r = r/(2**c2)
    #print('r3',r)
    if r ==1 and c3 >=c2:
        print(c3+(c3-c2))
    else:
        print(-1)