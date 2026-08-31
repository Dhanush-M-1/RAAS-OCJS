def compute(n, s):
    dic = {}
    most_common = ""

    for i in range(n-1):
        cur = s[i:i+2]
        if not(cur in dic):
            dic[cur] = 1
        else:
            dic[cur] += 1
            
        if not most_common:
            most_common = cur
        else:
            if dic[cur] > dic[most_common]:
                most_common = cur
            
    return most_common
                

        

if __name__ == "__main__":
    n = int(input())
    
    s = str(input())
    print(compute(n, s))
