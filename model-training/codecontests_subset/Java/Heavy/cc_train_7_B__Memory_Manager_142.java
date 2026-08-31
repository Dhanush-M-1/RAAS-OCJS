var l = readline().split(' ')
var i, j
var t = l[0]
var mt = l[1]
var m = []
var b = []
var bn = 0
var r

for (i = 0; i < mt; i++) m[i] = 0

for (i = 0; i < t; i++) {
  l = readline().split(' ')
  var op = l[0]
  var n = l[1]
  if (op == 'alloc') {
    print(r = alloc(n))
  } else if (op == 'erase') {
    r = erase(n)
    if (r) print(r)
  } else if (op == 'defragment') {
    defragment()
  }
}

function alloc (n) {
  var i, j = 0
  for (i = 0; i < mt; i++) {
    if (!m[i]) {
      j++
      if (j == n) {
        b[++bn] = [i - j + 1, i]
        while (j > 0) {
          m[i - j + 1] = 1
          j--
        }
        return bn
      }
    } else {j = 0}
  }
  return 'NULL'
}

function erase (n) {
  if (b[n]) {
    for (var i = b[n][0]; i <= b[n][1]; i++) m[i] = 0
    b[n] = null
  } else {
    return 'ILLEGAL_ERASE_ARGUMENT'
  }
}

function defragment () {
  var j = 0
  for (var i = 0; i < mt; i++) {
    if (!m[i]) {j++}
    else if (j) {
      var mmb
      for (var t = 0; t <= bn; t++) {
        if (b[t] && b[t][0] == i) {
          mmb = b[t]
          break
        }
      }
      for (var k = mmb[0]; k <= mmb[1]; k++) {
        m[k] = 0
        m[k - j] = 1
      }
      mmb[0] -= j
      mmb[1] -= j
      j = 0
    }
  }
}