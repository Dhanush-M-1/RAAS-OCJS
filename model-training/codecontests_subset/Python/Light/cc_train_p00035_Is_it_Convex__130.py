while True:
  try:
    data = list(map(float,input().split(",")))
  except EOFError:
    break
  vec1 = [data[2]-data[0],data[3]-data[1]]
  vec2 = [data[4]-data[0],data[5]-data[1]]
  vec3 = [data[6]-data[0],data[7]-data[1]]
  a = (vec2[0]*vec3[1] - vec2[1]*vec3[0]) / (vec1[0]*vec3[1] - vec1[1]*vec3[0])
  b = (vec2[0]*vec1[1] - vec2[1]*vec1[0]) / (vec1[1]*vec3[0] - vec1[0]*vec3[1])
  if (a < 0 or b < 0) or a+b < 1.0:
    print("NO")
  else:
    print("YES")
