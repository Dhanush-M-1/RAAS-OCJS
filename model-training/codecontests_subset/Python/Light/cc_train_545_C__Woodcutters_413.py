def main():
    n = int(input())
    trees = []

    for i in range(n):
        x,h = map(int,input().split())
        trees.append([x,h])

    max_trees = min(2,n)

    for i in range(1,n-1):
        x,h = trees[i][0],trees[i][1]
        if x-h > trees[i-1][0]:
            max_trees += 1
        elif x+h < trees[i+1][0]:
            max_trees += 1
            trees[i][0] += h

    print (max_trees)

main()
