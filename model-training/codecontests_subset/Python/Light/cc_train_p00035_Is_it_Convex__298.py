while True:
    try:
        x_a, y_a, x_b, y_b, x_c, y_c, x_d, y_d = map(float, input().split(","))
        ab = [x_b - x_a, y_b - y_a]
        bc = [x_c - x_b, y_c - y_b]
        cd = [x_d - x_c, y_d - y_c]
        da = [x_a - x_d, y_a - y_d]
        crs_a = -(ab[0]*da[1] - ab[1]*da[0])
        crs_b = -(bc[0]*ab[1] - bc[1]*ab[0])
        crs_c = -(cd[0]*bc[1] - cd[1]*bc[0])
        crs_d = -(da[0]*cd[1] - da[1]*cd[0])
        if crs_a*crs_b*crs_c*crs_d < 0:
            print("NO")
        else:
            print("YES")
    except:
        break

