#include <bits/stdc++.h>
using namespace std;

const int N = 100005;

struct Info{ int s, e, x, y; };

int n, A, t[N], q;
Info a[N];

int main(){
    scanf("%d%d", &A, &n);
    a[0] = {0, A, 0, 0};
    for(int i = 1; i <= n; i++){
        scanf("%d", t + i);
        int dt = t[i] - t[i - 1];
        auto &p = a[i - 1];
        int ns = p.s, ne = p.e;
        if(~i & 1){ ns += dt; ne += dt; }
        else{ ns -= dt; ne -= dt; }
        if(ns >= A) a[i] = {A, A, 0, A};
        else if(ne > A) a[i] = {ns, A, p.x, p.y + ne - A};
        else if(ne <= 0) a[i] = {0, 0, A, 0};
        else if(ns < 0) a[i] = {0, ne, p.x - ns, p.y};
        else a[i] = {ns, ne, p.x, p.y};
    }
    scanf("%d", &q);
    for(int x, y, z; q--; ){
        scanf("%d%d", &x, &y);
        z = int(upper_bound(t, t + n + 1, x) - t - 1);
        y = max(a[z].s, min(a[z].e, a[z].s + y - a[z].x));
        if(z & 1) y = min(A, y + x - t[z]);
        else y = max(0, y - x + t[z]);
        printf("%d\n", y);
    }
}