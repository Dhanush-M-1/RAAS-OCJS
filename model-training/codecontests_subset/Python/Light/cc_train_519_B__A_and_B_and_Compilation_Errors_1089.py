fi_l = input()
fi_l = int(fi_l)
se_l = input()
th_l = input()
fo_l = input()
fo_l = list(map(int,fo_l.split()))
se_l = list(map(int,se_l.split()))
th_l = list(map(int,th_l.split()))
def summ(n):
    j=0
    
    for i in range(0,len(n)):
        
        j=n[i]+j
    return(j)
print((summ(se_l)-summ(th_l)),(summ(th_l)-summ(fo_l)))