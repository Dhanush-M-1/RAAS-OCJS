
def check(s):
    ss_even = [i for i in s if i%2==0]
    ss_odd  = [i for i in s if i%2==1]
   
    
    ss_even.sort()
    ss_odd.sort()
    l_even = len(ss_even)
    l_odd = len(ss_odd)
    
    if len(s)==0:
        return 0
    elif (l_even ==0):
        rem = l_odd - 1
    elif (l_odd==0):
        rem = l_even -1
    else:
        rem = abs(l_even-l_odd)
        rem = abs(max(rem-1,0))
    
            
    
    
    if (l_even > l_odd):
        return sum(ss_even[:rem])
    else :
        return sum(ss_odd[:rem])
    
    
    
n = int(input())

s = [int(i) for i in input().split()]

print(check(s))