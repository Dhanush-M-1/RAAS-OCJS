def main():
    dec = {'a':0,'b':1,'c':2,'d':3,'e':4,'f':5,'g':6,'h':7,'i':8,'j':9,'k':10,'l':11,'m':12,'n':13,'o':14,'p':15,'q':16,'r':17,'s':18\
              ,'t':19,'u':20,'v':21,'w':22,'x':23,'y':24,'z':25}
    for case in range(int(input())):
        n,m = map(int,input().split())
        st = input()
        ind = list(map(int,input().split()))
        op = [0]*(26)
        #
        g = [0]*26
        dic = {}
        for i in ind:
            if i in dic.keys():
                dic[i]+=1
            else:
                dic[i]=1


        for i in range(n):
            if i in dic.keys():
                x = dic[i]
                #print(i,st[i])
                for k in range(26):
                    op[k] = g[k]*x+op[k]
            g[dec[st[i]]] +=1

        #print(g)
        for k in range(26):
            op[k] = g[k] + op[k]
        for i in op:
            print(i,end = " ")
        print()






main()