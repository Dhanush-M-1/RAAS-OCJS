if __name__=="__main__":
    t=int(input())
    while(t):
        t-=1
        n=int(input())
        li=list(map(int,input().split()))
        i=0
        j=1
        k=len(li)-1
        flag=0
        while(i<len(li)-2):
            while(j<len(li)-1):
                while(j<k):
                    if li[i]+li[j]>li[k] and li[j]+li[k]>li[i] and li[k]+li[i]>li[j]:
                        pass
                    else:
                        flag=1
                        print(i+1,j+1,k+1)
                        break
                    k-=1
                j+=1
                if flag==1:
                    break
            i+=1
            if flag==1:
                break
        if flag==0:
            print(-1)
