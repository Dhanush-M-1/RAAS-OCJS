#include <bits/stdc++.h>
using namespace std;
#define db(x) cout << #x << "=" << x << "  "
#define el cout << endl;
#define re(i, n) for(int i = 0; i < n; ++i)
const int MXN = 2e5 + 10;

int X, D, U, K, Q;
int R[MXN], T[MXN], A[MXN];

int clip(int x, int low = 0, int high = X) {
    return max(low, min(x, high));
}

int delta = 0, tim = 0;
void adv(int t) {
    delta += t, tim += abs(t);
    U = clip(U + t);
    D = clip(D + t);
}

int main() {
    cin >> X >> K;
    re(i, K) scanf("%d", R + i);
    cin >> Q;
    D = 0, U = X;
    int p = 0;
    re(i, Q) {
        scanf("%d %d", T + i, A + i);
        while (p < K && R[p] < T[i]) {
            adv((R[p] - tim) * ((p & 1) * 2 - 1));
            ++p;
        }
        adv((T[i] - tim) * ((p & 1) * 2 - 1));
        printf("%d\n", clip(A[i] + delta, D, U));
    }
    return 0;
}