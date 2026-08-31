def sint():
    return (int(input()))

def sints():
    return (map(int, input().split()))

def sara():
    return (list(map(int,input().split())))

def sstr():
    s = input()
    return (list(s[:len(s)]))

def main():
    
    n, x, y = sints()
    s = input()  
    cnt = 0
    
    for i in range(n-1, n-x-1, -1):
        if i != n-y-1 and s[i] == '1':
            cnt += 1
        elif i == n-y-1 and s[i] == '0':
            cnt += 1
    print(cnt)
   
if __name__ == "__main__":
    main() 
    
    
