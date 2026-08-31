def solve(n,trees):
    big = float('inf')
    small = float('-inf')
    res = 1
    trees[0].append("L")
    trees.append([big,big])
    for i in range(1,n):
        flag = True
        if trees[i - 1][-1] != "R":
            if trees[i][0] - trees[i][1] > trees[i - 1][0]:
                flag = False
                res += 1
                trees[i].append("L")
        if flag:
            if trees[i - 1][-1] == "R" and trees[i][0] - trees[i][1] > trees[i - 1][0] + trees[i - 1][1]:
                res += 1
                trees[i].append("L")

            elif trees[i][0] + trees[i][1] < trees[i + 1][0]:
                res += 1
                trees[i].append("R")
    # print(trees)
    return res

def main():
    t = int(input())
    trees = []
    for i in range(t):        
        d = input()
        d = [int(i) for i in d.split()]       
        a = d[0]
        b = d[1]
        trees.append([a,b])        
    ans = solve(t,trees) 
    print(ans)     
        # for i in ans:
        #     print(i,end = "")
        # print()  
main()

x = [0]