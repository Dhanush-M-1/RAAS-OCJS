from math import ceil
def main():
    mode="filee"
    if mode=="file":f=open("test.txt","r")
    #f.readline()
    #input()
    get = lambda :[int(x) for x in (f.readline() if mode=="file" else input()).split()]
    [n,x,y]=get()
    total = ceil((y/100)*n)
    if total >x:
        print(total-x)
    else:
        print(0)


    if mode=="file":f.close()


if __name__=="__main__":
    main()
