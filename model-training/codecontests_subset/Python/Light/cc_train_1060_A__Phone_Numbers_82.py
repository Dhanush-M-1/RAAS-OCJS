#python is so shitty
n=input();s=str(input())
def main():
    m=len(s)//11
    counter=0
    for i in s:
        if i=="8":
            counter+=1
    print(min(counter,m)) 
main()