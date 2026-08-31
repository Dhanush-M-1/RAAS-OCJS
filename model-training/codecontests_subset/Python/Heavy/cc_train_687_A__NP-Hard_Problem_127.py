import sys,threading
sys.setrecursionlimit(10**6)
threading.stack_size(10**8)
def main():
        global al,va,ca,ml
        
        n,m=map(int,input().split())
        ml=[-1]*(n+1)
        al=[[]for i in range(n+1)]
        for i in range(m):
                a,b=map(int,input().split())
                al[a].append(b)
                al[b].append(a)
                ml[a]=1
                ml[b]=1

        va=[0]*(n+1)
        ca=[-1]*(n+1)
        
        #print(ans,al)
        for e in range(1,n+1):
                if(va[e]==0):
                        z=dfs(e,0)
                        if(z==True):
                                pass
                        else:
                                break
                        
        #print(ca,z)
        if(z==False):
                print("-1")
        else:
                print(ca.count(0))
                
                for i in range(1,n+1):
                        if(ca[i]==0):
                                print(i,end=" ")
                print()
                print(ca.count(1))
                for i in range(1,n+1):
                        if(ca[i]==1):
                                print(i,end=" ")
                
        
        
def dfs(n,col):
        global al,va,ca
        va[n]=1
        ca[n]=col
        for e in al[n]:
                if(va[e]==0):
                        
                        z=dfs(e,ca[n]^1)
                        if(z==False):
                                return False
                else:
                        if(ca[n]==ca[e]):
                                return False
        return True
           
        

t=threading.Thread(target=main)
t.start()
t.join()

