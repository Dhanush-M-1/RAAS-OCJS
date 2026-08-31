T = int(input())

def by_six(n):
    if n%6==0:
        return True
    else:
        return False

def by_three(n):
    if n%3==0:
        return True
    else:
        return False

def main():
    n = int(input())
    if n==1:
        return 0
    if n==2:
        return -1
    
    count = 0
    while n>2:
        #print(n,count)
        if by_six(n):
            n=n//6
            count=count+1
            continue
            
        if by_three(n):
            n=n*2
            n=n//6
            count=count+2
            continue
        
        else:
            return -1
    if n==2:
        return -1
    else:
        return count
    
for i in range(T):
    print(main())