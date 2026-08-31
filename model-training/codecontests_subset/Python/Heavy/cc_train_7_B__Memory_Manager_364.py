def main(): 
    t, m = map(int, input().split())#t:Cantidad de ordenes dadas, m:Tamaño de memoria disponible en bytes
    mem = [0]*m
    iden = 1 #Identificador de los bloques
    ans = [] #Respuestas
    
    for _ in range(t):
        orders = list(input().split()) 
        order = orders[0] #Órden
        if len(orders) == 2: n = orders[1]; n = int(n) #Número de la orden
        
        if order == "alloc":
            for i in range(m - n + 1):
                if mem[i : i+n] == [0]*n:
                    mem[i : i+n] = [iden]*n
                    ans.append(iden)
                    iden += 1
                    break
            else:
                ans.append("NULL")
            
        elif order == "erase":
            
            if n < 1: ans.append("ILLEGAL_ERASE_ARGUMENT")
            elif n in mem:
                mem = [0 if i == n else i for i in mem]                
            else: ans.append("ILLEGAL_ERASE_ARGUMENT")
            
        elif order == "defragment":
            for _ in range(m):
                if 0 in mem: mem.remove(0)
            mem = mem + [0]*(m-int(len(mem)))
              
    for i in ans: print(i)    
    
    
if __name__ == "__main__":
    main()