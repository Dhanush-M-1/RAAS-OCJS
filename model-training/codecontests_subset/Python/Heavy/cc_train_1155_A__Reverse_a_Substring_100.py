def nxtSmallest(string, n):

    stack = []

    top = -1

    res = []

    for i in range(n-1, -1, -1):

        curr = string[i]

        while top >= 0 and string[stack[top]] >= curr:
            stack.pop()
            top-=1
        
        if top == -1: res.append(-1)

        else: res.append(stack[top])

        stack.append(i)
        top+=1
    
    res.reverse()

    # print(res)

    for i in range(n):
        if res[i] != -1:
            return i+1, res[i]+1
    

    return None


n = int(input())

string = input()

res = nxtSmallest(string, n)

if res == None: print("NO")

else:
    print("YES")

    print(*res)


