if __name__=='__main__':
    n=int(input())
    s=input()
    cnt=0
    for c in s:
        if c=='8':
            cnt+=1
    print(min(int(len(s)/11),cnt))