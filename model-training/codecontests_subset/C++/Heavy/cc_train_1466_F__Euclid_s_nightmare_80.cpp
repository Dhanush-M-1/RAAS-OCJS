#include <iostream>
#include <vector>
using namespace std;

const int maxn = 5e5 + 5;
const int mod = 1e9 + 7;
int f[maxn];
int Find(int u) {
    if (u != f[u]) {
        f[u] = Find(f[u]);
    }
    return f[u];
}
int main() {
    int n, m;
    scanf("%d %d", &n, &m);
    for (int i = 1; i <= m; i++) {
        f[i] = i;
    }
    vector<int> V;
    for (int i = 1; i <= n; i++) {
        int k;
        scanf("%d", &k);
        if (k == 1) {
            int x;
            scanf("%d", &x);
            int fx = Find(x);
            int f0 = Find(0);
            if (fx == f0) {
                continue;
            }
            f[fx] = f0;
            V.push_back(i);
        } else {
            int x1, x2;
            scanf("%d %d", &x1, &x2);
            int fx1 = Find(x1);
            int fx2 = Find(x2);
            if (fx1 == fx2) {
                continue;
            }
            f[fx1] = fx2;
            V.push_back(i);
        }
    }
    long long ans = 1;
    for (int i = 1; i <= V.size(); i++) {
        ans = ans * 2 % mod;
    }
    printf("%lld %d\n", ans, V.size());
    for (int i = 0; i < V.size(); i++) {
        printf("%d ", V[i]);
    }
    puts("");
}