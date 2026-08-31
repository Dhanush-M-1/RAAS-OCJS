#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

class Operation {
    int l, r, d;
public:
    Operation() : l(0), r(1<<30), d(0) {};
    Operation(int l, int r, int d) : l(l), r(r), d(d) {}
    int apply(int a) {
        return max(l, min(r, a + d));
    };
    Operation append(Operation op) {
        if (r + op.d <= op.l) return Operation(op.l, op.l, d + op.d);
        else if (l + op.d >= op.r) return Operation(op.r, op.r, d + op.d);
        else return Operation(max(l + op.d, op.l), min(r + op.d, op.r), d + op.d);
    }
};

Operation operator*(Operation lhs, Operation rhs) {
    return lhs.append(rhs);
}

int main() {
    int x, k; cin >> x >> k;
    int r[k]; for (int i = 0; i < k; i++) cin >> r[i];
    vector<Operation> ops;
    ops.push_back(Operation(0, x, 0));
    for (int i = 1; i <= k; i++) {
        int r1 = i == 1 ? 0 : r[i-2], r2 = r[i-1];
        ops.push_back(ops[i-1] * Operation(0, x, (r2 - r1) * (i % 2 ? -1 : 1)));
    }
    int q; cin >> q;
    while (q--) {
        int t, a; cin >> t >> a;
        int i = upper_bound(r, r+k, t) - r;
        int a1 = ops[i].apply(a);
        cout << Operation(0, x, (t - (i > 0 ? r[i-1] : 0)) * (i % 2 ? 1 : -1)).apply(a1) << endl;
    }
}
