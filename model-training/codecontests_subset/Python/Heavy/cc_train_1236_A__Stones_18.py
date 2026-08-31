from sys import stdout,stdin
for i in range(int(stdin.readline())):
    a,b,c=stdin.readline().split()
    a,b,c=int(a),int(b),int(c)
    cont=0
    cant_c=c//2
    cant_b_con_c=b
    if cant_c<=cant_b_con_c:
        cont+=cant_c*2
        cont+=cant_c
        b=b-cant_c
    else:
        cont+=cant_b_con_c*2
        cont+=cant_b_con_c
        b=b-cant_b_con_c
    cant_a = a
    cant_b_con_a = b // 2

    if cant_b_con_a<=cant_a:
        cont+=cant_b_con_a*2
        cont+=cant_b_con_a
    else:
        cont+=cant_a*2
        cont+=cant_a

    stdout.write(str(cont)+"\n")

