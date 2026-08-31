def main():
    a,b = input().split()
    a,b = int(a),int(b)
    i =1
    while i <= a:
        if i%b == 0:
            a += 1
        i +=1
    print(a)
if __name__ == "__main__" : main()