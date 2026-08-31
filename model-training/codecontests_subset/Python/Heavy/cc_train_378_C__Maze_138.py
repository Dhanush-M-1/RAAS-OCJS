import sys
import threading
n,m,k = map(int,input().split())
matrix = []
for i in range(n):
    row = input()
    r=[]
    for j in range(len(row)):
        r.append(row[j])
    matrix.append(r)
number_of_empty_cell = 0
global count
count = 0
 
for i  in range(n):
    for j in range(m):
        if matrix[i][j]==".":
            number_of_empty_cell+=1
def isSafe(i,j):
    return True if 0<= i < n and 0<= j < m else False
def boarder_check(i,j):
    return True if i==0 or j==0 or i==n-1 or j==m-1 else False
 

def dfs(i,j):
    global count
    if count < number_of_empty_cell-k:
        matrix[i][j]="$"
        count+=1
        if isSafe(i,j+1) and matrix[i][j+1]==".":
            dfs(i,j+1)
        if isSafe(i+1,j) and matrix[i+1][j]==".":
            dfs(i+1,j)
        if isSafe(i,j-1) and matrix[i][j-1]==".":
            dfs(i,j-1)
        if isSafe(i-1,j) and matrix[i-1][j]==".":
            dfs(i-1,j)
 


def main():
    for i in range(n):
        for j in range(m):
                if matrix[i][j]==".":
                    dfs(i,j)
    for i in range(n):
        for j in range(m):
            if matrix[i][j]=="$":
                matrix[i][j]="."
            elif matrix[i][j]==".":
                matrix[i][j] = "X"

    for i in range(n):
        s = "".join(matrix[i])
        print(s,end="\n")


if __name__ == "__main__":
    sys.setrecursionlimit(10**6)
    threading.stack_size(10**8)
    t = threading.Thread(target=main)
    t.start()
    t.join()