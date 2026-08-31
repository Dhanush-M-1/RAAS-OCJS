from sys import stdin,stdout
import bisect

def main():
    for _ in range(int(stdin.readline())):
        play,clear=0,0
        counter=0
        n=int(stdin.readline())
        matrix=[]
        for i in range(n):
            p,c=map(int,stdin.readline().split())
            matrix.append((p,c))
        for i in range(n):
            p=matrix[i][0]
            c=matrix[i][1]
            pl=p-play
            cl=c-clear
            if cl<0:
                counter=1
                break
            elif pl<0:
                counter=1
                break
            elif cl>pl:
                counter=1
                break
            else:
                
                play=p
                clear=c
                continue
        if counter==1:
            print("NO")
        else:
            print("YES")
            
                
        
    
    
if __name__=="__main__":
    main()
            