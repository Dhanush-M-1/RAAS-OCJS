input()
ord1 = [int(i) for i in input().split()]
ord2 = [int(i) for i in input().split()]
ord3 = [int(i) for i in input().split()]
err1 = sum(ord1)- sum(ord2)
err2 = sum(ord2)- sum(ord3)
print(err1, err2, sep='\n')