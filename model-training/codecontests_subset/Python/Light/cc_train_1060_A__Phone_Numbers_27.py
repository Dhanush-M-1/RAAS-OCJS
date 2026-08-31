def solution(l1):
    i=0
    while i<len(l1):
        if l1[i]==8:
            l1[i]=1
        else:
            l1[i]=0
        i+=1
    l1.sort()
    i=0
    #print(l1)
    while len(l1)>10 and 1 in l1:
        l1.remove(1)
        for x in range (0,10):
            l1.remove(l1[0])
        i+=1
    return i
        
            
    
def answer():
    a = int(input())
    l1 = [int(x) for x in list(input())]
    print(solution(l1))
answer()