n,k = map(int, input().split())
oo = list()
oa = list()
ob = list()
for i in range(n):
        t,a,b = map(int, input().split())
        if a == 1 and b == 1:
                oo.append(t)
        elif a == 0 and b == 1:
                ob.append(t)
        elif a == 1 and b == 0:
                oa.append(t)
 
oo = sorted(oo)
oa = sorted(oa)
ob = sorted(ob)
 
oo_p = 0
oa_p = 0
ob_p = 0
 
ca = 0
cb = 0
ans = 0
MAX = 23942034809238409823048
if max(0, max(k-len(oa), k-len(ob))) > len(oo):
        print("-1")
        exit(0)
 
def get_first_elem_from_list(l, pos):
        if pos < len(l):
                return l[pos]
        else:
                return MAX
 
def remove_first_elem_from_list(l, pos):
        if len(l)>pos:
                pos += 1
        return pos
while ca < k or cb < k:
        oo_f = get_first_elem_from_list(oo, oo_p)
        oa_f = get_first_elem_from_list(oa, oa_p)
        ob_f = get_first_elem_from_list(ob, ob_p)
        if ca < k and cb < k:
                if oo_f <= oa_f + ob_f:
                        ca += 1
                        cb += 1
                        ans+=oo_f
                        oo_p = remove_first_elem_from_list(oo, oo_p)
                elif oa_f + ob_f < oo_f:
                        ca += 1
                        cb += 1
                        ans+=oa_f+ob_f
                        oa_p = remove_first_elem_from_list(oa, oa_p)
                        ob_p = remove_first_elem_from_list(ob, ob_p)
        elif ca < k:
                if oo_f <= oa_f:
                        ca += 1
                        ans+=oo_f
                        oo_p = remove_first_elem_from_list(oo, oo_p)
                elif oa_f < oo_f:
                        ca += 1
                        ans+=oa_f
                        oa_p = remove_first_elem_from_list(oa, oa_p)
        else:
                if oo_f <= ob_f:
                        cb += 1
                        ans+=oo_f
                        oo_p = remove_first_elem_from_list(oo, oo_p)
                elif ob_f < oo_f:
                        cb += 1
                        ans+=ob_f
                        ob_p = remove_first_elem_from_list(ob, ob_p)
print(ans)