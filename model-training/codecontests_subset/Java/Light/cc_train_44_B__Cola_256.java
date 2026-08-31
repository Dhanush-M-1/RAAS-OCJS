'use strict'

;(function () {
  let lll = readline().split(' ').map(v => parseInt(v))
  let N = lll[0]
  let A = lll[1]
  let B = lll[2]
  let C = lll[3]

  let vs = 0

  let a, b, c, n

  c = C
  do {
    n = N
    b = B
    n -= c * 2
    if (n < 0) continue
    do {
      let nn = n
      a = A
      nn -= b
      if (0 <= nn && nn <= a / 2)
        vs++
    } while (b--)
  } while (c--)
  print(vs)
})()