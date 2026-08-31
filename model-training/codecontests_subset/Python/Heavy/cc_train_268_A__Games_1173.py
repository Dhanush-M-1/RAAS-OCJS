def solve(color):
        count = 0
        for i in color:
                for j in color:
                        if (i == j):
                                continue
                        else:
                                if(i[0] == j[1]):
                                        count += 1

        return count

                                
if __name__ == "__main__":
        n = int(input())
        color = []
        for i in range(n):
                h,a = map(int,input().split())
                color.append([h,a])

        print(solve(color))
