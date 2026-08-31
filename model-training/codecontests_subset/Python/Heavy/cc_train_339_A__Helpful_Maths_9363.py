################################################################
# Code Forces
# Problem -  Helpful Maths
# 12/04/2020
# Ratings - 900
# Category - Greedy,Implementation,Sortings,String
################################################################

def main():
    s = list(map(int,input().split("+")))
    s.sort()
    for i in range(len(s)):
        print(s[i],end="")
        if(i<len(s)-1):
            print("+",end="")
        else:
            print("")

if __name__ == "__main__":
    main()
