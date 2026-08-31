'use strict'

const problem = (a, b, c) => {
    if (c >= 2 * b) return 3 * b;
    b -= c / 2 | 0;
    if (b >= 2 * a) return 3 * (a + c / 2 | 0);
    return 3 * ((b / 2 | 0) + (c / 2 | 0));
}


const t = +readline();

for (let i = 0; i < t; i++) {
    const x = readline().split(' ').map(Number);
    print(problem(x[0], x[1], x[2]));
}
