t=int(input())
def fan(k,s):
    a=0
    b=0
    for i in range(len(s)):
        if s[i]==">":
            break
        else:
            a+=1
    s1=s[::-1]
    for i in range(len(s)):
        if s1[i]=="<":
            break
        else:
            b+=1
    return(min(a,b))   


    # if s[0]==">" or s[-1]=="<" or len(s)==1:
    #     return(0)
    # else:
    #     return(1)            

    # if s[0]==min(a,b):
    #     return(1)
    # else:
    #     return(0)
def main():
    for _ in range(t):
        n=int(input())
        s=input()
        print(fan(n,s))



if __name__ == "__main__":
    main()        


