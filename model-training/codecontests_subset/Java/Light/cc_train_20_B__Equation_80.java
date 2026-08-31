'use strict'

let lll = readline().split(' ').map(v => parseInt(v))

const A = lll[0]
const B = lll[1]
const C = lll[2]

;(function () {
  if (A == 0) {
    if (B == 0) {
      if (C == 0) return print(-1)
      return print(0)
    }
    print(1)
    return print(-C / B)
  } else {
    const D = B * B - 4 * A * C
    if (D < 0) return print(0)
    if (D == 0) {
      print(1)
      return print(-B / (2 * A))
    }
    print(2)
    if (A > 0) {
      print((-B - Math.sqrt(D)) / (2 * A))
      print((-B + Math.sqrt(D)) / (2 * A))
    } else {
      print((-B + Math.sqrt(D)) / (2 * A))
      print((-B - Math.sqrt(D)) / (2 * A))
    }
  }
})()