line = input().split()

n,p,w,d = int(line[0]),int(line[1]),int(line[2]),int(line[3])

for i in range(w):
    temp = (p -i * d)
    if temp >= 0 and temp % w == 0 and (temp // w) + i <= n:
        print((temp // w),i,n - ((temp // w) + i))
        break
else:
    print(-1)


#El codigo anteriro es que se envio al codeForce, el que aparece a
#continuacion hace lo mismo, los cambios que presenta son la eliminacion
#de los print() por return para ser usado en el teset


# def optimal(n,p,w,d):
#     for i in range(w):      #se recorren los puntos que se otorgan por victoria
#         temp = (p - i * d)  #se asigna un valor a los empates y = i
#         if temp >= 0 and temp%w == 0 and (temp//w) + i <= n:    #se comprueba que dicho valor cumpla las condiciones
#             return [temp//w,i,n- temp//w - i]      #se devuelven la terna de valores x,y,z 
#     else:
#         return - 1
 