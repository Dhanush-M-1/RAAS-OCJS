#  =========     /\       /|    |====/|
#      |        /  \       |    |   / |
#      |       /____\      |    |  /  |
#      |      /      \     |    | /   |
#  ========= /        \  =====  |/====|  
#  code

if __name__ == "__main__":
    n,x,y = map(int,input().split())
    s = str(input())
    
    if x > len(s):
        x = len(s)

    sy = ["0"]*x
    sy[x-y-1]='1'

    cnt = 0
    c = 0
    for i in range(len(s)-x , len(s)):
        if sy[c] != s[i]:
            cnt += 1
        c += 1
    print(cnt)

   
    


    

